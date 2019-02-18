# 第一手果断 not in
select customers.name as Customers
from customers
where customers.id not in (
  select customerid from orders
);

# 左连接
SELECT A.Name as Customers from Customers A
LEFT JOIN Orders B on  a.Id = B.CustomerId
WHERE b.CustomerId is NULL;
