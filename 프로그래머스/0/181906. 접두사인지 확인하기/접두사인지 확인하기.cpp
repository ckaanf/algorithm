#include <string>
using namespace std;

int solution(string my_string, string is_prefix) {
    
    if (is_prefix.size() > my_string.size()) {
        return 0;
    }
  
    if (my_string.substr(0, is_prefix.size()) == is_prefix) {
        return 1;
    } else {
        return 0;
    }
}
