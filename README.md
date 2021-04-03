# SnakesAndLadders
This is a SpringBoot API application so to start please use run options on your IDE or run from terminal:

    ./gradlew bootRun

After that app is up and running. To test it please use your favorite API tools(like Postman) 
To start the game please do POST request:

    localhost:8080/starts

Your should receive Json response 

[
{
"name": "Name1",
"position": 1,
"status": true,
"winner": "No"
},
{
"name": "Name2",
"position": 1,
"status": false,
"winner": "No"
}
]

Now you should use this Json for playing the game.
please copied it and put into body and do a PUT request:

localhost:8080/games

Please do not forget to update the Json after each PUT request and one of the players will be winner



