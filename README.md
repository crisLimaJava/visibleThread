# Skeleton Spring APP

Steps to run the **Skeleton Spring APP** and **unit tests**

1 - Clone the project.

2 - Create Schema called **db_skeleton** on the MySQL Database running on port **3307** 

3 - Start the **SkeletonSpringApp**, it will create all the table on the database

4 - Populate all tables using the Script bellow:

    use db_skeleton;

    insert into team (name) 

    values 	('dev_team'),	('qa_team');

    insert into user (email, date_creation) 

    values	("devUser@email.com", str_to_date('16-01-2022 14:35:00', '%d-%m-%Y %H:%i:%s')),

    ("qaUser@email.com", str_to_date('01-04-2022 08:25:00', '%d-%m-%Y %H:%i:%s')),

    ("dev_qa_user@email.com", str_to_date('10-04-2022 13:00:00', '%d-%m-%Y %H:%i:%s'));
        
    insert into team_user

    values	(1, 1), (2, 2), (3, 1), (3, 2);        

    insert into document (document_name, upload_date, word_count ,user_id)

    values ("doc01", str_to_date('19-01-2022 12:00:00', '%d-%m-%Y %H:%i:%s'), 400, 1),

    ("doc02", str_to_date('15-02-2022 13:30:00', '%d-%m-%Y %H:%i:%s'), 475, 1),

    ("doc03", str_to_date('25-02-2022 14:00:00', '%d-%m-%Y %H:%i:%s'), 900, 1),

    ("doc04", str_to_date('04-04-2022 13:45:00', '%d-%m-%Y %H:%i:%s'), 533, 1);
    
  5 - The functionalities requested will be availables on the following endpoints:
  
**GET - localhost:8080/ssapp/user/getUsersWithoutUpload**
    
  parameters on request body
    
  String **"dateStart"**  ('dd-MM-yyyy HH:mm:ss')
  
  String **"dateEnd"** ('dd-MM-yyyy HH:mm:ss')
      
**GET - localhost:8080/ssapp/document/getWordFrequency**

  parameters on request body
    
  String **"document"**
