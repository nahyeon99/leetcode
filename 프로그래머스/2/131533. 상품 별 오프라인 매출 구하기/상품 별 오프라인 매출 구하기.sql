SELECT p.PRODUCT_CODE, SUM(o.SALES_AMOUNT) * p.PRICE AS SALES
FROM PRODUCT p
INNER JOIN OFFLINE_SALE o
ON p.PRODUCT_ID = o.PRODUCT_ID
GROUP BY p.PRODUCT_CODE
ORDER BY SALES DESC, PRODUCT_CODE ASC;
