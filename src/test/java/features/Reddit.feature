Feature: Reddit Up voting and Down Voting

Scenario: Reddit Upvote the First Post and Downvote the Second Post

Given User is on the Reddit Homepage
When Enteres a Search String on the Search and User Submits
Then User is navigated to the SubReddit Section
Then User Prints out the top most post title
Then User performs a Login
Then DownVote the Second post if its Upvoted
