
class Twitter {

    private static int timestamp = 0;

    class Tweet {
        int tweetId;
        int time;
        Tweet next;

        Tweet(int tweetId) {
            this.tweetId = tweetId;
            this.time = timestamp++;
        }
    }

    Map<Integer, Set<Integer>> following;
    Map<Integer, Tweet> tweets;

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

        Tweet tweet = new Tweet(tweetId);

        tweet.next = tweets.get(userId);
        tweets.put(userId, tweet);
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> result = new ArrayList<>();

        PriorityQueue<Tweet> pq =
                new PriorityQueue<>((a, b) -> b.time - a.time);

        if (tweets.containsKey(userId)) {
            pq.offer(tweets.get(userId));
        }

        Set<Integer> followees =
                following.getOrDefault(userId, new HashSet<>());

        for (int followee : followees) {
            if (tweets.containsKey(followee)) {
                pq.offer(tweets.get(followee));
            }
        }

        while (!pq.isEmpty() && result.size() < 10) {

            Tweet curr = pq.poll();
            result.add(curr.tweetId);

            if (curr.next != null) {
                pq.offer(curr.next);
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {

        if (followerId == followeeId) {
            return;
        }

        following
                .computeIfAbsent(followerId, k -> new HashSet<>())
                .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (!following.containsKey(followerId)) {
            return;
        }

        following.get(followerId).remove(followeeId);
    }
}