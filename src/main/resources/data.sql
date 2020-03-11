INSERT INTO my_item (item_id, item_name) VALUES
  (1, 'first item'),
  (2, 'second item'),
  (3, '3rd item'),
  (4, '4th item'),
  (5, '5th item'),
  (6, '6th item'),
  (7, '7th item'),
  (8, '8th item'),
  (9, '9th item');

  INSERT INTO my_bom (bom_id, bom_name, parent_item_id, child_item_id, quantity) VALUES
  (1, 'from 1 to 2 A',1, 2, 1),
  (2, 'from 1 to 2 B',1, 3, 2),
  (3, 'from 1 to 2 C',1, 4, 3),
  (4, 'from 1 to 2 B',2, 5, 2),
  (5, 'from 1 to 2 B',2, 6, 2);