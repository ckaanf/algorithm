-- 코드를 입력하세요
SELECT ANIMAL_ID,NAME FROM ANIMAL_INS
where INTAKE_CONDITION = 'Sick'
order by ANIMAL_ID
-- 동물 보호소에 들어온 동물 중 아픈 동물의 아이디와 이름을 조회/ 결과는 id 순