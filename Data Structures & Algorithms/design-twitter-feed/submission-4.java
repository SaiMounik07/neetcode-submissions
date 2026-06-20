class Twitter {
private static int timestamp = 0;
Map<Integer, Set<Integer>> followers ;
Map<Integer,List<Tweet>> posts;
    public Twitter() {
        followers = new HashMap<>();
        posts = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet t = new Tweet(tweetId,timestamp++);
        if(!posts.containsKey(userId)){
            posts.put(userId,new ArrayList<>());
        }
        posts.get(userId).add(t);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>((p,k) -> k.time - p.time);
        if(posts.containsKey(userId)){
            pq.addAll(posts.get(userId));
        }
        System.out.print(followers);
        if(followers.containsKey(userId)){
        for(Integer userIds : followers.get(userId)){
            pq.addAll(posts.get(userIds));
        }
        }
        while(!pq.isEmpty() && res.size()<10 ){
            res.add(pq.poll().tweetId);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        followers.computeIfAbsent(followerId,k -> new HashSet<>());
        followers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!followers.containsKey(followerId)) {
            return;
        }
        followers.get(followerId).remove(followeeId);
    }
    
}
class Tweet{
    public int time;
    public int tweetId;
    Tweet(int tweetId,int time){
        this.tweetId = tweetId;
        this.time = time;
    }
}
