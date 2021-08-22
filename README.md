# Roulette API 
Technical test for dev role in Masiv

Spring Boot, MongoDB, Docker.


### Run project

 Run maven
 `mvn clean install`
 
 Start up our docker-compose
 `docker-compose up --build`

## ENDPOINTS 
### Create Roulette
POST http://localhost:8080/api/v1/roulettes
RETURNS
```
response
{
    "metadata": [
        {
            "Message": "Created El codigo de la ruleta es: 6121f8491c9262664a2ae4bd",
            "Status Code": "201"
        }
    ],
    "rouletteResponse": {
        "roulette": [
            {
                "id": "6121f8491c9262664a2ae4bd",
                "status": null,
                "bets": [],
                "winnerNumber": null
            }
        ]
    }
}
```

 
 ### Open Roulette
 PUT http://localhost:8080/api/v1/roulettes/612230ee8af0230b107c9b53/openup
 Status: true = Roulette is open
 
 ```
 {
    "metadata": [
        {
            "Message": "Created Roulette with code: 612230ee8af0230b107c9b53 has been initialized",
            "Status Code": "201"
        }
    ],
    "rouletteResponse": {
        "roulette": [
            {
                "id": "612230ee8af0230b107c9b53",
                "status": true,
                "bets": [],
                "winnerNumber": null
            }
        ]
    }
}
```

 ### Betting
 POST http://localhost:8080/api/v1/roulettes/6122330cfea7a1744c890adc/bet
 HEADER: userId 11818181
 RETURNS
 
 ```
 {
    "metadata": [
        {
            "Message": "Created A Bet has been created in Roulette with code: 6122330cfea7a1744c890adc",
            "Status Code": "201"
        }
    ],
    "rouletteResponse": {
        "roulette": [
            {
                "id": "6122330cfea7a1744c890adc",
                "status": true,
                "bets": [
                    {
                        "id": "612235c1fea7a1744c890add",
                        "status": null,
                        "number": 1,
                        "moneyInGame": 1500.0,
                        "moneyWon": 0.0,
                        "color": null
                    }
                ],
                "winnerNumber": null
            }
        ]
    }
}
```
 
### Close Roulette
 PUT http://localhost:8080/api/v1/roulettes/6122330cfea7a1744c890adc/close
 ```
 {
    "metadata": [
        {
            "Message": "OK Roulette with6122330cfea7a1744c890adchas been closed",
            "Status Code": "200"
        }
    ],
    "rouletteResponse": {
        "roulette": [
            {
                "id": "6122330cfea7a1744c890adc",
                "status": false,
                "bets": [
                    {
                        "id": "61223643fea7a1744c890ade",
                        "status": "winner",
                        "number": 5,
                        "moneyInGame": 0.0,
                        "moneyWon": 0.0,
                        "color": null
                    },
                    {
                        "id": "6122395a6d41b85a47ad3d0b",
                        "status": "defeated",
                        "number": null,
                        "moneyInGame": 0.0,
                        "moneyWon": 0.0,
                        "color": "RED"
                    },
                    {
                        "id": "612239666d41b85a47ad3d0c",
                        "status": "defeated",
                        "number": null,
                        "moneyInGame": 0.0,
                        "moneyWon": 0.0,
                        "color": "BLACK"
                    },
                    {
                        "id": "612239736d41b85a47ad3d0d",
                        "status": "defeated",
                        "number": null,
                        "moneyInGame": 0.0,
                        "moneyWon": 0.0,
                        "color": "RED"
                    },

                ],
                "winnerNumber": null
            }
        ]
    }
}
```



### Find All Roulettes with status
GET http://localhost:8080/api/v1/roulettes
 ```{
    "metadata": [
        {
            "Message": "OK",
            "Status Code": "200"
        }
    ],
    "rouletteResponse": {
        "roulette": [
            {
                "id": "61222e29995f1927a845743d",
                "status": null,
                "bets": [],
                "winnerNumber": null
            },
            {
                "id": "61223013520f6c4931f83cfc",
                "status": null,
                "bets": [],
                "winnerNumber": null
            },
            {
                "id": "6122305f32969061f1265dac",
                "status": null,
                "bets": [],
                "winnerNumber": null
            },
            {
                "id": "612230ee8af0230b107c9b53",
                "status": true,
                "bets": [],
                "winnerNumber": null
            },
            {
                "id": "6122330cfea7a1744c890adc",
                "status": true,
                "bets": [
                    {
                        "id": "612235c1fea7a1744c890add",
                        "status": null,
                        "number": 1,
                        "moneyInGame": 1500.0,
                        "moneyWon": 0.0,
                        "color": null
                    },
                    {
                        "id": "61223643fea7a1744c890ade",
                        "status": null,
                        "number": 5,
                        "moneyInGame": 5000.0,
                        "moneyWon": 0.0,
                        "color": null
                    }
```

