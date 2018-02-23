--Entrypass table
INSERT INTO "ENTRYPASS" (id, uname, pwd) VALUES(1L, 'shailendra','1234');
INSERT INTO "ENTRYPASS" (id, uname, pwd) VALUES(2L, 'ashish','1234');
INSERT INTO "ENTRYPASS" (id, uname, pwd) VALUES(3L, 'amey','1234');

-- NGO table -- single quots
INSERT INTO "NGO" (ngo_id, short_desc, long_desc, summary, type, img_url, rating) 
VALUES (10L, 'CRY', 'Save a child life today', 'Cry is a well recognized government funded organization.', 'Children', 'child-random.jpg','3.2');
INSERT INTO "NGO" (ngo_id, short_desc, long_desc, summary, type, img_url, rating) 
VALUES (11L, 'Greenpeace', 'Protect the world', 'Green Peace is the oldest NGO working in the enviornment protection like Water and Air sustainability.', 'Enviornment', 'child-school.jpg','3.4');
INSERT INTO "NGO" (ngo_id, short_desc, long_desc, summary, type, img_url, rating) 
VALUES (12L, 'YoSoldier', 'Gaurd your guards', 'This NGO is working for our brave soldiers and their well being.', 'Soldier', 'child-school.jpg','3.1');
INSERT INTO "NGO" (ngo_id, short_desc, long_desc, summary, type, img_url, rating) 
VALUES (13L, 'SaveTheChildren', 'Child Sponsorer', 'Save the Children is working nonstop supporting refugee girls and boys.', 'Children', 'child-school.jpg','3.7');
INSERT INTO "NGO" (ngo_id, short_desc, long_desc, summary, type, img_url, rating) 
VALUES (14L, 'HelpAgeInc', 'Help to seniors', 'Fighting Isolation, Poverty and neglect', 'Elderly', 'man-hungry.jpg','3.3');

--- Cause table
INSERT INTO "CAUSE" (cause_id, short_desc, long_desc, type, img_url, opening_tag, situation, total_cost, accumulated_tillnow, currency)
VALUES (20L, 'Will you help her?', 'Help her to see world', 
			 'children', 
			 'sick-baby3.jpg', 
			 'Will you help her live and see the beautiful world you have seen?', 
			 'The desperate tot is 5 and half months old and has been diagnosed with a rare condition that strikes only 200 children a year worldwide. It is a condition called AveolaCapilliary Dysplasia, meaning her lungs were not properly formed.',
			 1200L, 
			 300L, 
			 '$');
--INSERT INTO "CAUSE" (cause_id, short_desc, long_desc, type, img_url) 
--VALUES (20L, 'Will you help her ?', 'Will you help her live and see the beautiful world you have seen? Situation - The desperate tot is 5 and half months old and has been diagnosed with a rare condition that strikes only 200 children a year worldwide. It is a condition called AveolaCapilliary Dysplasia, meaning her lungs were not properly formed. What is needed - The cost of operating for the lung transplantation is $20000. We are raising $12000 for this operation',
--		'children','child.jpg');
		
INSERT INTO "CAUSE" (cause_id, short_desc, long_desc, type, img_url, opening_tag, situation, total_cost, accumulated_tillnow, currency)
VALUES (21L, 'Your soldiers!', 'Will you help your Army men?',
		'veterans',
		'soldiers.jpg',
		'When we sleep peacefully they keep you safe',
		'They are injured and retired and need your help for better future of their children and family.',
		2400L,
		150L,
		'$');	
		
INSERT INTO "CAUSE" (cause_id, short_desc, long_desc, type, img_url, opening_tag, situation, total_cost, accumulated_tillnow, currency)
VALUES (22L, 'Child Refugee Crisis', 'Help for Syrian children',
		'children',
		'children-refugees.jpg',
		'Caught in the crossfire of conflict and crisis',
		'At least 7.6 million people, including 3.5 million children, are displaced from Syria with little access to even basic services.',
		8000L,
		250L,
		'$');

INSERT INTO "CAUSE" (cause_id, short_desc, long_desc, type, img_url, opening_tag, situation, total_cost, accumulated_tillnow, currency)
VALUES (23L, 'Fight Poverty', 'Give them basic facilities',
		'children',
		'poor-child.jpg',
		'Support them while they trying hard to stand up on their feet',
		'At least 7.6 million people, including 3.5 million children, are displaced from Syria with little access to even basic services.',
		8000L,
		250L,
		'$');
		
INSERT INTO "CAUSE" (cause_id, short_desc, long_desc, type, img_url, opening_tag, situation, total_cost, accumulated_tillnow, currency)
VALUES (24L, 'Child Education', 'Sponsor a child',
		'children',
		'poverty-shoes.jpg',
		'Education is the best charity for a growing mind',
		'At least 7.6 million people, including 3.5 million children, are displaced from Syria with little access to even basic services.',
		8000L,
		250L,
		'$');
		
INSERT INTO "CAUSE" (cause_id, short_desc, long_desc, type, img_url, opening_tag, situation, total_cost, accumulated_tillnow, currency)
VALUES (25L, 'Support for seniors', 'They deserve a dignified old age',
		'elderly',
		'old-homeless.jpg',
		'Thousands of old people are homeless in your country',
		'Homes for the Aged are ideal for elderly people who are alone, face health problems, depression and loneliness.',
		5600L,
		500L,
		'$');	
		
INSERT INTO "CAUSE" (cause_id, short_desc, long_desc, type, img_url, opening_tag, situation, total_cost, accumulated_tillnow, currency)
VALUES (26L, 'Helping hand to Cindy', 'Need your small financial support',
		'strugglingwm',
		'poverty-begger.jpg',
		'Thousands of old people are homeless in your country',
		'Cindy has no family and due to her weak body unable to get a job, Your charity will help her for a decent living.',
		500L,
		30L,
		'$');	
		
INSERT INTO "CAUSE" (cause_id, short_desc, long_desc, type, img_url, opening_tag, situation, total_cost, accumulated_tillnow, currency)
VALUES (27L, 'Helping hand to Theresa', 'Need your small financial support',
		'strugglingwm',
		'woman-begger.jpg',
		'Thousands of old people are homeless in your country',
		'Theresa has no family and due to her weak body unable to get a job, Your charity will help her for a decent living.',
		500L,
		30L,
		'$');
		
INSERT INTO "CAUSE" (cause_id, short_desc, long_desc, type, img_url, opening_tag, situation, total_cost, accumulated_tillnow, currency)
VALUES (28L, 'Homeless couple', 'They deserve a dignified old age',
		'elderly',
		'old-couple.jpg',
		'Thousands of old people are homeless in your country',
		'Homes for the Aged are ideal for elderly people who are alone, face health problems, depression and loneliness.',
		5600L,
		500L,
		'$');		

INSERT INTO "CAUSE" (cause_id, short_desc, long_desc, type, img_url, opening_tag, situation, total_cost, accumulated_tillnow, currency)
VALUES (29L, 'Retired solders', 'Contribute for their easy life post retirement?',
		'veterans',
		'soldier-kids.jpg',
		'When we sleep peacefully they keep you safe',
		'They are injured and retired and need your help for better future of their children and family.',
		2400L,
		150L,
		'$');	


		

-- Cuase ngo join table
INSERT INTO "NGO_CAUSE" (ncid, ngo_id, cause_id) VALUES(50L, 10L, 20L);
INSERT INTO "NGO_CAUSE" (ncid, ngo_id, cause_id) VALUES(51L, 11L, 20L);
INSERT INTO "NGO_CAUSE" (ncid, ngo_id, cause_id) VALUES(52L, 12L, 21L);
INSERT INTO "NGO_CAUSE" (ncid, ngo_id, cause_id) VALUES(53L, 13L, 22L);