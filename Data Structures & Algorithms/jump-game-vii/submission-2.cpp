class Solution {
public:
    bool canReach(string s, int minJump, int maxJump) {
        queue<int> q;
        int n=s.length();
        for(int i=0;i<n;i++) {
            if(s[i]=='0') {
                cout<<"J "<<i<<endl;
                q.push(i);
            }
        }
        queue<int> q1;
        int tem=q.front(); q1.push(tem);
        q.pop();
        while(q.size()!=0&&q1.size()!=0) {
            int tem2=q1.front();
            q1.pop();
            while(q.size()!=0&& q.front()<=min(tem2+maxJump,n-1)) {
                int tem1=q.front();
                cout<<tem1<<" "<<tem2<<endl;
                q.pop();
                if(tem2+minJump<=tem1) {
                q1.push(tem1);
                if(tem1==n-1) {
                    return true;
                }
                }
            }
        }
        return false;
    }
};