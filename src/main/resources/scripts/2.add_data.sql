use spring_homework;
INSERT INTO producer VALUES
(1,'Ubisoft'),
(2,'RockstarGames'),
(3, 'CD project');

INSERT INTO product VALUES
(1,'Assassins creed', 10000.00),
(2, 'Heroes', 15000),
(3, 'GTA Vice City', 10000),
(4, 'Red Dead', 1200),
(5, 'Witcher', 13000);

INSERT INTO user VALUES
(1, 'alex3000@gmail.com', 'eufyiuny','Alex', 'Syhoy', 'user', 'active'),
(2, 'vasylshevich@gmail.com','fwf5454f', 'Vasyl', 'Shevich', 'user', 'active'),
(3, 'ahfaifh@gmail.com', 'dhddjd', 'Misha', 'Esenin', 'admin', 'active');

INSERT INTO  producer_products VALUES
(1,1), (1,2),(2,3),(2,4),(3,5);