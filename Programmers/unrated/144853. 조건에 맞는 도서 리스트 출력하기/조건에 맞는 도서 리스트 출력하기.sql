-- 코드를 입력하세요
SELECT BOOK_ID, DATE_FORMAT(BOOK.PUBLISHED_DATE,'%Y-%m-%d') as PUBLISHED_DATE FROM BOOK
where CATEGORY = '인문' and YEAR(PUBLISHED_DATE) =2021

-- BOOK 테이블에서 2021년에 출판된 '인문' 카테고리에 속하는 도서리스트를 찾아서 BOOK_ID. PUBLISHED_DATE 를 출력