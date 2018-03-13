Use Payara server
attention a bien parametrer java en 1.8 et l'artifact exploded.

================================================
Bonne pratique pour getter une instance de bd : 

Session session = factory.openSession();
Transaction tx = null;

try {
   tx = session.beginTransaction();
   // do some work
   ...
   tx.commit();
}

catch (Exception e) {
   if (tx!=null) tx.rollback();
   e.printStackTrace(); 
} finally {
   session.close();
}

================================================

Tutorial Hibernate :
https://www.tutorialspoint.com/hibernate/hibernate_mapping_files.htm