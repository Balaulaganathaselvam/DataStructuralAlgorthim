select column1,column2,count(*) AS count
from your_table
group by column1,column2
having count(*) >1

select e.name,d.department_name
from employee e
INNER JOIN departments d on e.department_id = d.department_id;

select e.name,d.department_name
from employee e
LEFT JOIN departments d on e.department_id = d.department_id
LEFT JOIN analysis p on e.analysis_id = p.analysis_id

select e.name,d.department_name
from employee e
OUTER JOIN departments d on e.department_id = d.department_id;

select distinct salary
from employees
order by salary DESC
LIMIT 1 offset 1;

select MAX(salary)
from employees
where salary <(select max(salary) from employees);

select departmnet_id ,count(*) as emp_count
from employees
group by department_id
having count(*) > 5;

select e.name as employeename,e.salary as empSalary,m.name as manager_name,m.salary as manager_salary
from emplyees e
joins employees m on e.managerId = m.id
where e.salary >m.salary;

select name, department,salary,
ROW_Number() OVER (partition by  department order by salary desc) as row_num
from employees;

select prodcut_id,product,total_gas
from sales_data
order by total_sales desc
limit 3;

select prodcut , total
from (select * ,rank() OVER(ORDER BY TOTAL_SALES DESC) AS rank_num from sales_data) ranked_sales
where rank_num <= 3;

