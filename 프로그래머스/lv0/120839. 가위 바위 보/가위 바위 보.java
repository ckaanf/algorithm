class Solution {
    public String solution(String rsp) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rsp.length(); i++) {
            sb.append(rsp.split("")[i].equals("2") ? "0"
                            : rsp.split("")[i].equals("0") ? "5" : "2");
        }
        return sb.toString();
    }
}
/*
String 을 탐색하여
2 ->0
0 -> 5
5 ->2 로 변환
*/