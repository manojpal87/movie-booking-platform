INSERT INTO theatre (id, name, address, city_id, total_seat, seat_available) VALUES (1, 'Audi_1', 'Pune Rural', 1, 50, 50);
INSERT INTO theatre (id, name, address, city_id, total_seat, seat_available) VALUES (2, 'Audi_2', 'Mumbai suberbs', 2, 75, 75);

INSERT INTO movie (id, theatre_id, name,language,genre,show_time,is_available,actual_ticket_Price,discounted_Price) VALUES (1,1, 'Don',    'Hindi',  'ACTION',   'EVENING', true, 100, 0);
INSERT INTO movie (id, theatre_id, name,language,genre,show_time,is_available,actual_ticket_Price,discounted_Price) VALUES (2,1, 'Don 2',  'Hindi',   'ACTION',  'NIGHT',   true, 150,0);
INSERT INTO movie (id, theatre_id, name,language,genre,show_time,is_available,actual_ticket_Price,discounted_Price) VALUES (3,2, 'Topgun', 'English', 'ROMANCE', 'MORNING', true, 50,0);
