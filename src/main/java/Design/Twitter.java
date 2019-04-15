package Design;

import java.util.*;

public class Twitter {

    private Map<Integer, Set<Integer>> followMap;

    private List<Tweet> tweetList;

    /** Initialize your data structure here. */
    public Twitter() {
        followMap = new HashMap<>();
        tweetList = new ArrayList<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweetList.add(new Tweet(userId, tweetId));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        for (int i = tweetList.size()-1; i >= 0; i--) {
            if (res.size() == 10) break;
            Tweet tweet = tweetList.get(i);
            if (userId == tweet.userId || (followMap.containsKey(userId) && followMap.get(userId).contains(tweet.userId)))
                res.add(tweet.tweetId);
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followMap.get(followerId) != null && followMap.get(followerId).contains(followeeId))
            followMap.get(followerId).remove(followeeId);
    }

    class Tweet {
        int userId;
        int tweetId;
        Tweet(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }
}
