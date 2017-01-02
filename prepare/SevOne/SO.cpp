// 1. if input number, add one and print, if string reverse it, keep the digit for float

#include <iostream>
using namespace std;


int main()
{
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    // suppose would run forever
    while (1)
    {
        string input_string;
        getline(cin, input_string);
        // default is string
        int type = 1;
        //now we need to judge what type it is
        if (isdigit(input_string.at(0)))
        {
            
            type = 0;
        }
        // incase it is negative number, - at first
        else
        {
            if (input_string.at(0) == '-')
            {
                if (input_string.length() > 1 && isdigit(input_string.at(1))) {
                    type = 0;
                }
            }
        }
    
        // if numeric, add one
        if (type == 0)
        {
            
            float input = stof(input_string);
            input += 1;
            cout << input << endl;
        }
        // if string, reverse it
        else if (type == 1)
        {
            int len = input_string.length();
            char input_chars[len];
            sprintf(input_chars, "%s", input_string.c_str());
            for (int i = 0, j = len - 1; i < len / 2; ++i, --j)
            {
                char temp = input_chars[i];
                input_chars[i] = input_chars[j];
                input_chars[j] = temp;
            }
            cout << input_chars << endl;
        }
    }
    

    return 0;
}







#include <iostream>
using namespace std;


int main()
{
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    // suppose would run forever
    while (1)
    {
        string input_string;
        getline(cin, input_string);
        int len = input_string.length();
        // default is string
        int type = 1;
        //now we need to judge what type it is
        if (isdigit(input_string.at(0)))
        {
            if (len == 1) {
                type = 0;
            }
            // loop over the string
            int num_of_dot = 0;
            for (int i = 1; i < len; ++i) {
                char cur = input_string.at(0);
                if (!isdigit(cur) && cur != '.') {
                    break;
                }
                if (cur == '.') {
                    ++num_of_dot;
                    // more than one dot is illegal
                    if (num_of_dot > 1) {
                        break;
                    }
                }
                if (i == len - 1) {
                    // dot at last position is illegal
                    if (cur == '.') {
                        break;
                    }
                    type = 0;
                }
            }
        }
        // incase it is negative number, - at first
        else
        {
            if (input_string.at(0) == '-')
            {
                if (len > 1 && isdigit(input_string.at(1))) {
                    if (len == 2) {
                        type = 0;
                    }
                    // loop over the string
                    int num_of_dot = 0;
                    for (int i = 2; i < len; ++i) {
                        char cur = input_string.at(0);
                        if (!isdigit(cur) && cur != '.') {
                            break;
                        }
                        if (cur == '.') {
                            ++num_of_dot;
                            // more than one dot is illegal
                            if (num_of_dot > 1) {
                                break;
                            }
                        }
                        if (i == len - 1) {
                            // dot at last position is illegal
                            if (cur == '.') {
                                break;
                            }
                            type = 0;
                        }
                    }
                }
            }
        }
    
        // if numeric, add one
        if (type == 0)
        {
            
            float input = stof(input_string);
            input += 1;
            cout << input << endl;
        }
        // if string, reverse it
        else if (type == 1)
        {
            char input_chars[len];
            sprintf(input_chars, "%s", input_string.c_str());
            for (int i = 0, j = len - 1; i < len / 2; ++i, --j)
            {
                char temp = input_chars[i];
                input_chars[i] = input_chars[j];
                input_chars[j] = temp;
            }
            cout << input_chars << endl;
        }
    }
    

    return 0;
}



// 2. transpose matrix and print

// 3. fix bug, % 3  == 0 Fizz, % 5 == 0 Buzz, all FizzBuzz 

// 4. fix bug, when erase element in vector, need to record the iterator

// 5. fibonacci number with transform, remove_if and accumulate

bool IsEven(int i) {
    return ((i % 2) == 0);
}

int functional_fibonacci(int range) {
    // edge case
    if (range <= 1)
        return 1;
    
    std::vector<int> list;
    // initiallize the origin list first
    list.push_back(0);
    list.push_back(1);
    list.push_back(1);
    for (int i = 3; i <= range + 1; ++i) {
        list.push_back(0);
    }
       
    // calculate the fibonacci number using current postion and last postion, store the sum to next position
    std::transform(list.begin(), list.end() - 2, list.begin() + 1, list.begin() + 2, std::plus<int>());
    vector<int>::iterator new_end = std::remove_if(list.begin(), list.end(), IsEven);

    return std::accumulate(list.begin(), new_end, 0);
}





