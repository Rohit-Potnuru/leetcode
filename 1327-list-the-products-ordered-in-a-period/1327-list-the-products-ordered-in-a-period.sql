WITH febOrders AS (
    SELECT product_id, SUM(unit) as unit
    FROM orders
    where YEAR(order_date)='2020' AND MONTH(order_date)='02'
    GROUP BY product_id
    HAVING SUM(unit) >= 100
)

SELECT p.product_name, fo.unit
FROM febOrders fo
LEFT JOIN products p ON (p.product_id = fo.product_id)
