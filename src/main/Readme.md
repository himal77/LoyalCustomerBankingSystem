# About
Task given to Himal Puri on 24 September For Loyalty program for our customer

# DESCRIPTION FOR USE
-> First change url, username and password in org.springframework.jdbc.datasource.DriverManagerDataSource
in file spring-servlet.xml

After database is connected.

->Admin part at home

To use the website, first register admin.
Then login with admin. and add few customer.
Admin can add, update and delete customer.

-> Customer part

Login with a customer accountNo and password
There will be four part.

    1) to see customer point history
    2) to view or collect point
    3) to view transaction history
    4) do transaction
    
-> In transaction, There is withdrawal, deposit and transfer

# Important
-> To stimulate for real life banking system and for testing purpose.

1) Date can be added by ourselves
2) A transaction cannot be done before the last transaction date for the customer.
3) points can be added only on sunday, if the customer had transaction of 500 in that week or
    if he has transaction on every day of that week.
4) Points are calculated, according to specification.

    