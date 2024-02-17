class Solution {
public:
    void reverseWords(string &s) {
        string temp = s;
        std::stack<string> stack_temp;
        
        // push stack
        do
        {
            if(temp.size() <= 0)
		    {
			    break;
	    	}
	    	//find space
            int pos = temp.find(" ");
            if(pos==-1)
            {
                //no space found
                stack_temp.push(temp);
                break;
            }
		    if(pos > 0)
		    {
			    string sub = temp.substr(0, pos);
			    stack_temp.push(sub);
		    }
            temp.erase(0,pos+1);
        }
        while(true);
        
        // pop stack
        temp = "";
        while(!stack_temp.empty())
        {
            string top = stack_temp.top();
            stack_temp.pop();
            temp += top;
            if(!stack_temp.empty())
            {
                temp +=" ";
            }
        }
        
        s = temp;
    }
};