## Examen Trip Planning



### 3.3.3 
I will only be showing the first 4 trips out of the 12 that is in the populator so that it doesn't take up too much space.
#### GET http://localhost:7007/api/trip
    {
        "id": 1,
        "starttime": "09:00",
        "endtime": "15:00",
        "startposition": "Alaska",
        "name": "Snowy Peaks Adventure",
        "price": 70.0,
        "category": "SNOW"
    }
    {
        "id": 2,
        "starttime": "13:00",
        "endtime": "19:00",
        "startposition": "Hawaii",
        "name": "Sunny Beach Day",
        "price": 55.0,
        "category": "BEACH"
    },
    {
        "id": 3,
        "starttime": "11:00",
        "endtime": "17:00",
        "startposition": "Minnesota",
        "name": "Lake Serenity",
        "price": 65.0,
        "category": "LAKE"
    },
    {
        "id": 4,
        "starttime": "07:30",
        "endtime": "13:30",
        "startposition": "Colorado",
        "name": "Forest Trail Hike",
        "price": 45.0,
        "category": "FOREST"
    }
#### GET http://localhost:7007/api/trip/1
    {
        "id": 1,
        "starttime": "09:00",
        "endtime": "15:00",
        "startposition": "Alaska",
        "name": "Snowy Peaks Adventure",
        "price": 70.0,
        "category": "SNOW"
    }
#### POST http://localhost:7007/api/trip
    {
        "id": null,
        "starttime": "13:00",
        "endtime": "20:00",
        "startposition": "Norway",
        "name": "Snowboarding",
        "price": 5000.0,
        "category": "SNOW"
    }
#### PUT http://localhost:7007/api/trip/13
    {
        "id": 13,
        "starttime": "13:00",
        "endtime": "20:00",
        "startposition": "Sweeden",
        "name": "Snowboarding",
        "price": 4000.0,
        "category": "SNOW"
    }
#### DELETE http://localhost:7007/api/trip/13
    HTTP/1.1 204 No Content
    Date: Mon, 04 Nov 2024 10:52:32 GMT
    Content-Type: text/plain
    
    <Response body is empty>


### 3.3.5
I would assume it's because we all ready have created the trips and the guides so its easier to just update it with the corresponding guide

