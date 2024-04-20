SET @hour := -1; -- 로컬 변수 선언

SELECT
    (@hour := @hour + 1) AS HOUR,
    (SELECT 
        COUNT(*) 
    FROM 
        ANIMAL_OUTS
    WHERE HOUR(DATETIME) = @hour) as COUNT
FROM
    ANIMAL_OUTS
WHERE
    @hour < 23