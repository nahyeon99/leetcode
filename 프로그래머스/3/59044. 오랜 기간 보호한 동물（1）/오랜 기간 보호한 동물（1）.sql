select NAME, DATETIME
from ANIMAL_INS 
where ANIMAL_ID NOT IN (
    select ANIMAL_ID 
    from ANIMAL_OUTS)
order by DATETIME
limit 3