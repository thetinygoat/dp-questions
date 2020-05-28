#include <bits/stdc++.h>
using namespace std;
string process(string p){
        string s;
        bool prev = false;
        for(char c: p){
                if(c == '*'){
                        if(!prev){
                                s += c;
                                prev = true;
                        }
                }else {
                        s+= c;
                        prev = false;
                }
        }
return s;
}
int solve(string &s, string &p, int i, int j, vector<vector<int>> &dp){
        if(i == s.length() && j == p.length()) return dp[i][j] = 1;
        else if(i == s.length() || j == p.length()){
                if(i != s.length()){
                        return dp[i][j] = 0;
                }
                return dp[i][j] = (p[j] == '*' && p.length() - j == 1) ? 1 : 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        bool res = false;
        if(s[i] == p[j] || p[j] == '?') res = solve(s,p,i+1,j+1,dp) == 1;
        else if(p[j] == '*'){
                res = res || solve(s,p,i,j+1,dp) == 1; // treat as empty string
                res = res || solve(s,p,i+1,j,dp) == 1;
        }
        return dp[i][j] = res ? 1 : 0;
}
bool isMatch(string s, string p){
        p = process(p);
        vector<vector<int>> dp(s.length()+1, vector<int>(p.length()+1,-1));
        return solve(s, p,0, 0,dp);
}

int main(){
        return 0;
}
