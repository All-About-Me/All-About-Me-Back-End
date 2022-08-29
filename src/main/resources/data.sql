INSERT INTO users (id, email, password, first_name, last_name) VALUES (
    1500,
    'testuser@gmail.com',
    'password',
    'Test',
    'User'
);

INSERT INTO posts (id, text, date, image_url, author_id) VALUES (
    10000,
    'The classic',
    '2022-08-28 01:01:01',
    'https://i.imgur.com/fhgzVEt.jpeg',
    1
),
(
    10001,
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.',
    '2022-08-28 01:01:01',
    '',
    1
); 