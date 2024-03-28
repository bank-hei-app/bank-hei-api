CREATE OR REPLACE FUNCTION generate_account_statement(p_account_id VARCHAR, p_start_date DATE, p_end_date DATE)
RETURNS TABLE (
    transaction_date DATE,
    reference VARCHAR,
    reason VARCHAR,
    credit DOUBLE PRECISION,
    debit DOUBLE PRECISION,
    balance DOUBLE PRECISION
) AS $$
BEGIN
RETURN QUERY
SELECT
    t.date_of_transaction AS transaction_date,
    COALESCE(bt.reference_unique, '') AS reference,
    bt.balance_category_name AS reason,
    CASE WHEN bt.balance_type_name = 'Credit' THEN t.amount ELSE 0.00 END AS credit,
    CASE WHEN bt.balance_type_name = 'Debit' THEN t.amount ELSE 0.00 END AS debit,
    COALESCE((SELECT SUM(CASE WHEN bt1.balance_type_name = 'Credit' THEN t1.amount ELSE -t1.amount END)
               FROM transactions t1
               JOIN balance_category bc1 ON t1.balance_category_id = bc1.balance_category_id
               JOIN balance_type bt1 ON t1.balance_type_id = bt1.balance_type_id
               WHERE t1.account_id = p_account_id
               AND t1.date_of_transaction <= t.date_of_transaction), 0.00) AS balance
FROM
    transactions t
LEFT JOIN
    bank_transfer bt ON t.balance_category_id = bt.balance_category_id
LEFT JOIN
    balance_type btype ON t.balance_type_id = btype.balance_type_id
LEFT JOIN
    balance_category bcategory ON t.balance_category_id = bcategory.balance_category_id
WHERE
    t.account_id = p_account_id AND
    t.date_of_transaction BETWEEN p_start_date AND p_end_date
ORDER BY
    t.date_of_transaction DESC;
END; $$
LANGUAGE plpgsql;
