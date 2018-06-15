INSERT INTO PERSONS(id,first_name,last_name,email,dtype) VALUES (1,'Juan Manuel','Romero','jmanuelromero93@gmail.com','U'),(2,'Eva María','Mera','evamera@gmail.com','U')
INSERT INTO USERS(person_id,username,password_hash) VALUES (1,'jumarome','$2a$10$i0u9UhT54a4Lkq8o4DbYruqA3ewMDld.5gsKvSi93e2DclUoVN2f6'),(2,'evamera','$2a$10$bERZEGAbRYKG9e1ZojwLcOGqhM13ZQ2RTjQtSriGkyQp.uUDteIfm')
INSERT INTO groups(id,name) VALUES (1,'staff'),(2,'admin')
INSERT INTO users_groups(user_id, groups_id) VALUES (1,2),(2,1)