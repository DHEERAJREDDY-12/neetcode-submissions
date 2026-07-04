class Twitter {
    int time;
    HashMap<Integer,List<int[]>> tmap;
    HashMap<Integer,HashSet<Integer>> map;

    public Twitter() {
        tmap=new HashMap<>();
        map=new HashMap<>();
        time=0;
    }

    public void postTweet(int userId,int tweetId) {
        tmap.putIfAbsent(userId,new ArrayList<>());
        tmap.get(userId).add(new int[]{time++,tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans=new ArrayList<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);

        if(tmap.containsKey(userId)){
            List<int[]> tweets=tmap.get(userId);
            int ind=tweets.size()-1;
            int[] t=tweets.get(ind);
            pq.offer(new int[]{t[0],t[1],userId,ind});
        }

        if(map.containsKey(userId)){
            for(int followee:map.get(userId)){
                if(tmap.containsKey(followee)){
                    List<int[]> tweets=tmap.get(followee);
                    int ind=tweets.size()-1;
                    int[] t=tweets.get(ind);
                    pq.offer(new int[]{t[0],t[1],followee,ind});
                }
            }
        }

        while(!pq.isEmpty()&&ans.size()<10){
            int[] cur=pq.poll();
            ans.add(cur[1]);
            int u=cur[2];
            int ind=cur[3];

            if(ind-1>=0){
                int[] prev=tmap.get(u).get(ind-1);
                pq.offer(new int[]{prev[0],prev[1],u,ind-1});
            }
        }

        return ans;
    }

    public void follow(int followerId,int followeeId) {
        if(followerId==followeeId){
            return;
        }
        map.putIfAbsent(followerId,new HashSet<>());
        map.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId,int followeeId) {
        if(map.containsKey(followerId)){
            map.get(followerId).remove(followeeId);
        }
    }
}