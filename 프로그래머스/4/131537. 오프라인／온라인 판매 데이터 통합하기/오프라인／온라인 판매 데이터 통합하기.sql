-- 코드를 입력하세요
    SELECT DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE, 
    PRODUCT_ID, 
    USER_ID, 
    SALES_AMOUNT
    FROM ONLINE_SALE
    WHERE Month(SALES_DATE)=3
-- 쿼리의 결과를 합치고, 중복된 ROW는 제거한다.
UNION
    SELECT DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE, 
    PRODUCT_ID, 
    null AS USER_ID, 
    SALES_AMOUNT
    FROM OFFLINE_SALE
    WHERE Month(SALES_DATE)=3
ORDER BY SALES_DATE, PRODUCT_ID, USER_ID;