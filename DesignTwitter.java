/*
Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the 10 most recent tweets in the user's news feed.

Implement the Twitter class:
Twitter() Initializes your twitter object.
void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId. Each call to this function will be made with a unique tweetId.
List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be ordered from most recent to least recent.
void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.
 
Example 1:
Input
["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
Output
[null, null, [5], null, null, [6, 5], null, [5]]
*/ 
class Tweet implements Comparable<Tweet> {
    int time;
    int tweetId;

    Tweet(int time, int tweetId) {
        this.time = time;
        this.tweetId = tweetId;
    }

    public int compareTo(Tweet that) {
        return that.time - this.time; // Max-heap: latest tweets come first
    }
}

class User {
    int userId;
    HashSet<Integer> followees;
    List<Tweet> tweets;

    User(int userId) {
        this.userId = userId;
        followees = new HashSet<>();
        tweets = new LinkedList<>();
        followees.add(userId); // follow self
    }

    void addTweet(Tweet t) {
        tweets.add(0, t); // insert at head to keep latest tweets at front
    }

    void follow(int followeeId) {
        followees.add(followeeId);
    }

    void unfollow(int followeeId) {
        if (followeeId != this.userId) { // can't unfollow self
            followees.remove(followeeId);
        }
    }
}

class Twitter {
    HashMap<Integer, User> userMap;
    int timeStamp;

    public Twitter() {
        userMap = new HashMap<>();
        timeStamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        userMap.putIfAbsent(userId, new User(userId));
        User user = userMap.get(userId);
        user.addTweet(new Tweet(timeStamp++, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        if (!userMap.containsKey(userId)) return new ArrayList<>();

        PriorityQueue<Tweet> pq = new PriorityQueue<>();
        User user = userMap.get(userId);

        for (int followeeId : user.followees) {
            User followee = userMap.get(followeeId);
            if (followee == null) continue;
            List<Tweet> tweets = followee.tweets;
            for (int i = 0; i < Math.min(10, tweets.size()); i++) {
                pq.offer(tweets.get(i));
            }
        }

        List<Integer> result = new ArrayList<>();
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            result.add(pq.poll().tweetId);
            count++;
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)) return;
        userMap.get(followerId).unfollow(followeeId);
    }
}
