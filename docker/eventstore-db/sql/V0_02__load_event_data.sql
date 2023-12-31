INSERT INTO events (stream_type, stream_id, version, event_type, payload)
VALUES 
    ('Game', '47d7f610-17a0-4e6b-9155-98bba4de1e9c', 1, 'GAME_CREATED', '{"name": "Opening Stanza", "createdAt": "2018-10-21T12:00:00Z", "minPlayers": 3, "maxPlayers": 5}'),
    ('Game', '47d7f610-17a0-4e6b-9155-98bba4de1e9c', 2, 'PLAYER_REGISTERED', '{"playerHandle": "Amadeus"}'),
    ('Game', '47d7f610-17a0-4e6b-9155-98bba4de1e9c', 3, 'PLAYER_REGISTERED', '{"playerHandle": "Beethoven"}'),
    ('Game', '47d7f610-17a0-4e6b-9155-98bba4de1e9c', 4, 'PLAYER_REGISTERED', '{"playerHandle": "Chopin"}'),
    ('Game', '47d7f610-17a0-4e6b-9155-98bba4de1e9c', 5, 'GAME_STARTED', '{"startedAt": "2018-10-21T21:00:00Z"}'),
    ('Game', '47d7f610-17a0-4e6b-9155-98bba4de1e9c', 6, 'GAME_COMPLETED', '{"completedAt": "2018-10-21T21:14:06Z", "results": [{"playerHandle": "Beethoven", "points": 10},{"playerHandle": "Amadeus", "points": 5},{"playerHandle": "Chopin", "points": 2}] }'),

     ('Game', '05907073-f640-461c-bd04-1cac4fc0b119', 1, 'GAME_CREATED', '{"name": "Princess party", "createdAt": "2018-10-21T12:00:00Z", "minPlayers": 3, "maxPlayers": 10}'),
    ('Game', '05907073-f640-461c-bd04-1cac4fc0b119', 2, 'PLAYER_REGISTERED', '{"playerHandle": "Ariel"}'),
    ('Game', '05907073-f640-461c-bd04-1cac4fc0b119', 3, 'PLAYER_REGISTERED', '{"playerHandle": "Belle"}'),
    ('Game', '05907073-f640-461c-bd04-1cac4fc0b119', 4, 'PLAYER_REGISTERED', '{"playerHandle": "Cinderella"}'),
    ('Game', '05907073-f640-461c-bd04-1cac4fc0b119', 5, 'PLAYER_REGISTERED', '{"playerHandle": "Daisy"}'),
    ('Game', '05907073-f640-461c-bd04-1cac4fc0b119', 6, 'PLAYER_REGISTERED', '{"playerHandle": "Esmeralda"}'),
    ('Game', '05907073-f640-461c-bd04-1cac4fc0b119', 7, 'PLAYER_REGISTERED', '{"playerHandle": "Faline"}'),
    ('Game', '05907073-f640-461c-bd04-1cac4fc0b119', 8, 'PLAYER_REGISTERED', '{"playerHandle": "Giselle"}'),
    ('Game', '05907073-f640-461c-bd04-1cac4fc0b119', 9, 'GAME_STARTED', '{"startedAt": "2018-10-21T21:05:00Z"}'),
    ('Game', '05907073-f640-461c-bd04-1cac4fc0b119', 10, 'GAME_COMPLETED', '{"completedAt": "2018-10-21T21:33:23Z", "results": [{"playerHandle": "Cinderella", "points": 10},{"playerHandle": "Daisy", "points": 5},{"playerHandle": "Ariel", "points": 2},{"playerHandle": "Belle", "points": 1}] }'),

     ('Game', '71fd4e36-a142-445e-a0f8-af601a6cce3b', 1, 'GAME_CREATED', '{"name": "Arnie classic", "createdAt": "2018-10-21T12:00:00Z", "minPlayers": 15, "maxPlayers": 100}'),
    ('Game', '71fd4e36-a142-445e-a0f8-af601a6cce3b', 2, 'PLAYER_REGISTERED', '{"playerHandle": "John Matrix"}'),
    ('Game', '71fd4e36-a142-445e-a0f8-af601a6cce3b', 3, 'PLAYER_REGISTERED', '{"playerHandle": "Ben Richards"}'),
    ('Game', '71fd4e36-a142-445e-a0f8-af601a6cce3b', 4, 'PLAYER_REGISTERED', '{"playerHandle": "Julius Benedict"}'),
    ('Game', '71fd4e36-a142-445e-a0f8-af601a6cce3b', 5, 'PLAYER_REGISTERED', '{"playerHandle": "John Kimble"}'),
    ('Game', '71fd4e36-a142-445e-a0f8-af601a6cce3b', 6, 'PLAYER_REGISTERED', '{"playerHandle": "Jericho Cane"}'),
    ('Game', '71fd4e36-a142-445e-a0f8-af601a6cce3b', 7, 'PLAYER_REGISTERED', '{"playerHandle": "Harry Tasker"}'),
    ('Game', '71fd4e36-a142-445e-a0f8-af601a6cce3b', 8, 'PLAYER_REGISTERED', '{"playerHandle": "Dutch"}'),
    ('Game', '71fd4e36-a142-445e-a0f8-af601a6cce3b', 9, 'PLAYER_REGISTERED', '{"playerHandle": "Douglas Quaid"}'),
    ('Game', '71fd4e36-a142-445e-a0f8-af601a6cce3b', 10, 'PLAYER_REGISTERED', '{"playerHandle": "Conan"}'),
    ('Game', '71fd4e36-a142-445e-a0f8-af601a6cce3b', 11, 'PLAYER_REGISTERED', '{"playerHandle": "Trench"}'),
    ('Game', '71fd4e36-a142-445e-a0f8-af601a6cce3b', 12, 'PLAYER_REGISTERED', '{"playerHandle": "Dr. Alex Hesse"}'),
    ('Game', '71fd4e36-a142-445e-a0f8-af601a6cce3b', 13, 'PLAYER_REGISTERED', '{"playerHandle": "Ray Owens"}'),
    ('Game', '71fd4e36-a142-445e-a0f8-af601a6cce3b', 14, 'PLAYER_REGISTERED', '{"playerHandle": "Jack Slater"}'),
    ('Game', '71fd4e36-a142-445e-a0f8-af601a6cce3b', 15, 'PLAYER_REGISTERED', '{"playerHandle": "Ivan Danko"}'),
    ('Game', '71fd4e36-a142-445e-a0f8-af601a6cce3b', 16, 'PLAYER_REGISTERED', '{"playerHandle": "Kalidor"}'),
    ('Game', '71fd4e36-a142-445e-a0f8-af601a6cce3b', 17, 'PLAYER_REGISTERED', '{"playerHandle": "John Kruger"}'),
    ('Game', '71fd4e36-a142-445e-a0f8-af601a6cce3b', 18, 'GAME_STARTED', '{"startedAt": "2018-10-21T21:10:00Z"}'),
    ('Game', '71fd4e36-a142-445e-a0f8-af601a6cce3b', 19, 'GAME_COMPLETED', '{"completedAt": "2018-10-21T22:12:43Z", "results": [{"playerHandle": "John Matrix", "points": 10},{"playerHandle": "Dutch", "points": 5},{"playerHandle": "Ben Richards", "points": 2},{"playerHandle": "John Kimble", "points": 1}] }'),

     ('Game', '5d93dee3-dca0-4039-85cc-2612c7ee19d2', 1, 'GAME_CREATED', '{"name": "Noongar", "createdAt": "2018-10-21T12:00:00Z", "minPlayers": 3, "maxPlayers": 10}'),
    ('Game', '5d93dee3-dca0-4039-85cc-2612c7ee19d2', 2, 'PLAYER_REGISTERED', '{"playerHandle": "Harley Bennell"}'),
    ('Game', '5d93dee3-dca0-4039-85cc-2612c7ee19d2', 3, 'PLAYER_REGISTERED', '{"playerHandle": "Lance Franklin"}'),
    ('Game', '5d93dee3-dca0-4039-85cc-2612c7ee19d2', 4, 'PLAYER_REGISTERED', '{"playerHandle": "Jonathon Griffin"}'),
    ('Game', '5d93dee3-dca0-4039-85cc-2612c7ee19d2', 5, 'PLAYER_DEREGISTERED', '{"playerHandle": "Lance Franklin"}'),
    ('Game', '5d93dee3-dca0-4039-85cc-2612c7ee19d2', 6, 'PLAYER_REGISTERED', '{"playerHandle": "Neville Jetta"}'),
    ('Game', '5d93dee3-dca0-4039-85cc-2612c7ee19d2', 7, 'PLAYER_REGISTERED', '{"playerHandle": "Lewis Jetta"}'),
    ('Game', '5d93dee3-dca0-4039-85cc-2612c7ee19d2', 8, 'PLAYER_DEREGISTERED', '{"playerHandle": "Neville Jetta"}'),
    ('Game', '5d93dee3-dca0-4039-85cc-2612c7ee19d2', 9, 'PLAYER_REGISTERED', '{"playerHandle": "Stephen Hill"}'),
    ('Game', '5d93dee3-dca0-4039-85cc-2612c7ee19d2', 10, 'PLAYER_REGISTERED', '{"playerHandle": "Bradley Hill"}'),
    ('Game', '5d93dee3-dca0-4039-85cc-2612c7ee19d2', 11, 'PLAYER_REGISTERED', '{"playerHandle": "Joshua Hill"}'),
    ('Game', '5d93dee3-dca0-4039-85cc-2612c7ee19d2', 12, 'GAME_STARTED', '{"startedAt": "2018-10-21T21:15:00Z"}'),
    ('Game', '5d93dee3-dca0-4039-85cc-2612c7ee19d2', 13, 'GAME_COMPLETED', '{"completedAt": "2018-10-21T21:49:49Z", "results": [{"playerHandle": "Lewis Jetta", "points": 10},{"playerHandle": "Joshua Hill", "points": 5},{"playerHandle": "Harley Bennell", "points": 2}] }'),

     ('Game', '6f582337-6328-4366-9686-a7695c361833', 1, 'GAME_CREATED', '{"name": "Whanau", "createdAt": "2018-10-21T12:00:00Z", "minPlayers": 3, "maxPlayers": 6}'),
    ('Game', '6f582337-6328-4366-9686-a7695c361833', 2, 'PLAYER_REGISTERED', '{"playerHandle": "Aaron Mauger"}'),
    ('Game', '6f582337-6328-4366-9686-a7695c361833', 3, 'PLAYER_REGISTERED', '{"playerHandle": "Brad Thorn"}'),
    ('Game', '6f582337-6328-4366-9686-a7695c361833', 4, 'PLAYER_REGISTERED', '{"playerHandle": "Carl Hayman"}'),
    ('Game', '6f582337-6328-4366-9686-a7695c361833', 5, 'PLAYER_REGISTERED', '{"playerHandle": "Dan Carter"}'),
    ('Game', '6f582337-6328-4366-9686-a7695c361833', 6, 'PLAYER_REGISTERED', '{"playerHandle": "Elliot Dixon"}'),
    ('Game', '6f582337-6328-4366-9686-a7695c361833', 7, 'PLAYER_REGISTERED', '{"playerHandle": "Frank Bunce"}'),
    ('Game', '6f582337-6328-4366-9686-a7695c361833', 8, 'GAME_STARTED', '{"startedAt": "2018-10-21T21:15:00Z"}'),
    ('Game', '6f582337-6328-4366-9686-a7695c361833', 9, 'PLAYER_LEFT', '{"playerHandle": "Frank Bunce"}'),
    ('Game', '6f582337-6328-4366-9686-a7695c361833', 10, 'GAME_COMPLETED', '{"completedAt": "2018-10-21T21:49:49Z", "results": [{"playerHandle": "Brad Thorn", "points": 10},{"playerHandle": "Dan Carter", "points": 5},{"playerHandle": "Carl Hayman", "points": 2}] }'),

     -- //Semis
    ('Game', '913254a8-8004-4928-b906-9fe5d4411629', 1, 'GAME_CREATED', '{"name": "October Semi Final 1", "createdAt": "2018-10-22T12:00:00Z", "minPlayers": 4, "maxPlayers": 9}'),
    ('Game', '913254a8-8004-4928-b906-9fe5d4411629', 2, 'PLAYER_REGISTERED', '{"playerHandle": "Beethoven"}'),
    ('Game', '913254a8-8004-4928-b906-9fe5d4411629', 3, 'PLAYER_REGISTERED', '{"playerHandle": "Chopin"}'),
    ('Game', '913254a8-8004-4928-b906-9fe5d4411629', 4, 'PLAYER_REGISTERED', '{"playerHandle": "Daisy"}'),
    ('Game', '913254a8-8004-4928-b906-9fe5d4411629', 5, 'PLAYER_REGISTERED', '{"playerHandle": "Belle"}'),
    ('Game', '913254a8-8004-4928-b906-9fe5d4411629', 6, 'PLAYER_REGISTERED', '{"playerHandle": "John Matrix"}'),
    ('Game', '913254a8-8004-4928-b906-9fe5d4411629', 7, 'PLAYER_REGISTERED', '{"playerHandle": "Ben Richards"}'),
    ('Game', '913254a8-8004-4928-b906-9fe5d4411629', 8, 'PLAYER_REGISTERED', '{"playerHandle": "Joshua Hill"}'),
    ('Game', '913254a8-8004-4928-b906-9fe5d4411629', 9, 'PLAYER_REGISTERED', '{"playerHandle": "Brad Thorn"}'),
    ('Game', '913254a8-8004-4928-b906-9fe5d4411629', 10, 'PLAYER_REGISTERED', '{"playerHandle": "Carl Hayman"}'),
    ('Game', '913254a8-8004-4928-b906-9fe5d4411629', 11, 'GAME_STARTED', '{"startedAt": "2018-10-22T21:00:00Z"}'),
    ('Game', '913254a8-8004-4928-b906-9fe5d4411629', 12, 'GAME_COMPLETED', '{"completedAt": "2018-10-22T21:25:19Z", "results": [{"playerHandle": "Brad Thorn", "points": 10},{"playerHandle": "John Matrix", "points": 5},{"playerHandle": "Carl Hayman", "points": 2}] }'),

     -- //Semi(2)
    ('Game', 'c737b3e0-56c7-45dd-bf49-2677756a4b6f', 1, 'GAME_CREATED', '{"name": "October Semi Final 2", "createdAt": "2018-10-22T12:00:00Z", "minPlayers": 4, "maxPlayers": 8}'),
    ('Game', 'c737b3e0-56c7-45dd-bf49-2677756a4b6f', 2, 'PLAYER_REGISTERED', '{"playerHandle": "Amadeus"}'),
    ('Game', 'c737b3e0-56c7-45dd-bf49-2677756a4b6f', 3, 'PLAYER_REGISTERED', '{"playerHandle": "Cinderella"}'),
    ('Game', 'c737b3e0-56c7-45dd-bf49-2677756a4b6f', 4, 'PLAYER_REGISTERED', '{"playerHandle": "Ariel"}'),
    ('Game', 'c737b3e0-56c7-45dd-bf49-2677756a4b6f', 5, 'PLAYER_REGISTERED', '{"playerHandle": "Dutch"}'),
    ('Game', 'c737b3e0-56c7-45dd-bf49-2677756a4b6f', 6, 'PLAYER_REGISTERED', '{"playerHandle": "John Kimble"}'),
    ('Game', 'c737b3e0-56c7-45dd-bf49-2677756a4b6f', 7, 'PLAYER_REGISTERED', '{"playerHandle": "Lewis Jetta"}'),
    ('Game', 'c737b3e0-56c7-45dd-bf49-2677756a4b6f', 8, 'PLAYER_REGISTERED', '{"playerHandle": "Harley Bennell"}'),
    ('Game', 'c737b3e0-56c7-45dd-bf49-2677756a4b6f', 9, 'PLAYER_REGISTERED', '{"playerHandle": "Dan Carter"}'),
    ('Game', 'c737b3e0-56c7-45dd-bf49-2677756a4b6f', 10, 'GAME_STARTED', '{"startedAt": "2018-10-22T21:00:00Z"}'),
    ('Game', 'c737b3e0-56c7-45dd-bf49-2677756a4b6f', 11, 'GAME_COMPLETED', '{"completedAt": "2018-10-22T21:25:19Z", "results": [{"playerHandle": "Dutch", "points": 10},{"playerHandle": "Dan Carter", "points": 5},{"playerHandle": "Amadeus", "points": 2}] }'),

     -- //Final
    ('Game', '01a08e2a-e888-4e50-8e31-403d66365fe3', 1, 'GAME_CREATED', '{"name": "October Final", "createdAt": "2018-10-23T12:00:00Z", "minPlayers": 4, "maxPlayers": 8}'),
    ('Game', '01a08e2a-e888-4e50-8e31-403d66365fe3', 2, 'PLAYER_REGISTERED', '{"playerHandle": "Brad Thorn"}'),
    ('Game', '01a08e2a-e888-4e50-8e31-403d66365fe3', 3, 'PLAYER_REGISTERED', '{"playerHandle": "John Matrix"}'),
    ('Game', '01a08e2a-e888-4e50-8e31-403d66365fe3', 4, 'PLAYER_REGISTERED', '{"playerHandle": "Carl Hayman"}'),
    ('Game', '01a08e2a-e888-4e50-8e31-403d66365fe3', 5, 'PLAYER_REGISTERED', '{"playerHandle": "Dutch"}'),
    ('Game', '01a08e2a-e888-4e50-8e31-403d66365fe3', 6, 'PLAYER_REGISTERED', '{"playerHandle": "Dan Carter"}'),
    ('Game', '01a08e2a-e888-4e50-8e31-403d66365fe3', 7, 'PLAYER_REGISTERED', '{"playerHandle": "Amadeus"}'),
    ('Game', '01a08e2a-e888-4e50-8e31-403d66365fe3', 8, 'GAME_STARTED', '{"startedAt": "2018-10-23T21:00:00Z"}'),
    ('Game', '01a08e2a-e888-4e50-8e31-403d66365fe3', 9, 'GAME_COMPLETED', '{"completedAt": "2018-10-22T21:25:19Z", "results": [{"playerHandle": "Brad Thorn", "points": 10},{"playerHandle": "John Matrix", "points": 5},{"playerHandle": "Dutch", "points": 2}] }')
    ; 
