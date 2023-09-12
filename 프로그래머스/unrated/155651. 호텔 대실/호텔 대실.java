import java.util.*;

class Solution {
    class Book{
        public Book(int start,int end){
            this.start = start;
            this.end = end;
        }
        int start,end;
    }
    
    int convertM(String time){
        StringTokenizer st = new StringTokenizer(time,":");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        return h*60+m;
    }
    
    List<Book> bookList = new ArrayList<>();
    
    public int solution(String[][] book_time) {
        for(String[] b : book_time){
            int start = convertM(b[0]);
            int end = convertM(b[1]);
            
            bookList.add(new Book(start,end));
        }
        
//     Arrays.sort(bookList, new Comperator<String[]>(){
            
//             @Override
//             public int compare(String[] o1, String[] o2){
//             if(o1.start == o2.start ) return o1.end - o2.end;
//             else return o1.end- o2.end;
//             }
//         });
        Collections.sort(bookList,(o1,o2)->{
            if(o1.start == o2.start) return o1.end - o2.end;
            else return o1.start - o2.start;
        });
        
        
        List<Integer> check = new ArrayList<>();
        
        for(Book book: bookList){
            boolean room = false;
            Collections.sort(check);
            for(int i = 0; i<check.size(); i++){
                int clean = check.get(i) +10;
                
                if(book.start >= clean){
                    check.set(i,book.end);
                    room = true;
                    break;
                }
            }
            if(!room) check.add(book.end);
        }
        return check.size();
    }
}

//그리디
//끝 시각으로 정렬
//Arrays.sort(s,e,Comperator<book> book){}
// if(가능하다면) 룸 하나 생성하고 넣어주고
//  if(룸하나로 되면) 넣어주고
// 안되면 룸 늘려주고 넣어주고
// 룸 출력