use spring_homework;
INSERT INTO manufacturer VALUES
(1,'Ubisoft'),
(2,'RockstarGames'),
(3, 'CD project');

INSERT INTO product VALUES
(1,'Assassins creed', 10000.00, 1),
(2, 'Heroes', 15000, 1),
(3, 'GTA Vice City', 10000, 2),
(4, 'Red Dead', 1200,2),
(5, 'Witcher', 13000,3);

INSERT INTO user VALUES
(1, 'alex3000@gmail.com', '$2a$10$DGrZQ0OaORwx2pjKB8m0ve4IeT1VHKpIdVYcCwymUXQriXIE5h5qm','Alex', 'Syhoy', 'ROLE_ADMIN', 'ACTIVE'),
(2, 'vasylshevich@gmail.com','$2a$10$GA196vVfpmoyQy9T7RloDeOENfABc/9p11CprRD8i7hB8EbvALpmO', 'Vasyl', 'Shevich', 'ROLE_USER', 'ACTIVE');

