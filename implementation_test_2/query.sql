-- 1
select *
from employees;

-- 2
select count(*) AS total_emp
from employees
where employees.job_tittle = lower('Manager');

-- 3
select employees.name, employees.salary
from employees
where department = 'Sales'
   OR department = 'Marketing';

-- 4
select avg(employees.salary) AS avg_salary
from employees
where joined_date >= DATE(NOW() - INTERVAL 5 YEAR);

-- 5
select emp.employee_id, emp.name, total_sales
from (select employees.employee_id, employees.name, sum(sd.sales) as total_sales
      from employees
               left join sales_data sd on employees.employee_id = sd.employee_id
      group by sd.employee_id) as emp
order by total_sales desc
limit 5;

-- 6
select employees.name, employees.salary, avg_salary
from employees
         left join (select department, avg(employees.salary) as avg_salary
                    from employees
                    group by department
                    order by avg_salary desc
                    limit 1) as emp on emp.department = employees.department
where employees.department = emp.department
order by salary desc;

-- 7
WITH emp_sales as (select employees.employee_id, employees.name, sum(sd.sales) as total_sales
                   from employees
                            left join sales_data sd on employees.employee_id = sd.employee_id
                   group by sd.employee_id)
select name,
       total_sales,
       RANK() over (order by total_sales desc) AS emp_ranking
from emp_sales;

-- 8
DELIMITER $$
CREATE PROCEDURE GetDepartmentEmp(
    IN department VARCHAR(100)
)
BEGIN
    select employees.*, (select sum(salary) from employees where employees.department = department) as total_salary
    from employees
    where employees.department = department
    order by salary desc;
END$$
DELIMITER ;

CALL GetDepartmentEmp('Sales');
