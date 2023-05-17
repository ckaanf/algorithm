-- 코드를 입력하세요
SELECT DR_NAME,DR_ID,MCDP_CD,DATE_FORMAT(DOCTOR.HIRE_YMD,'%Y-%m-%d') AS HIRE_YMD from DOCTOR
where MCDP_CD in ('CS','GS')
order by HIRE_YMD DESC,DR_NAME 

-- 진료과가 흉부외과(CS) 이거나 (GS)인 의사의 이름,의사ID,진료과,고용일자를 조회
-- 결과를 고용일자 기준으로 내림차순 정렬, 고용일자가 같다면 이름을 기준으로 오름차순 정렬