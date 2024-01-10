<h1>microservices-based application:</h1>
<h3>I. Introduction</h3>
<p>The project aims to develop a comprehensive microservices-based application to manage various aspects of the e-commerce platform, with a specific focus on billing, product management, and customer interactions. The key components of the system include Consul Discovery, Spring Cloud Config, Spring Cloud Gateway, Customer-service, Inventory Service, Order Service, Consul Config for the Billing Service, Vault for the Billing Service, and a user Frontend Web developed with Angular.</p>
<h3>II. Project Steps</h3>

<h4>1.Consul Discovery:</h4>  

<p>Objective: Enable dynamic service discovery and registration.<p>
<img src="images/A4_consul2.png">
<br>
<h4><b>2.Spring Cloud Config:</b></h4>
<p>Objective: Centralized configuration management for microservices.</p>
<img src="images/springcloudconfig.png">
<h6>Actuator Refresh Configurations</h6>
<img src="images/configachaud_actuator.png">
<h6>Customer Configuration</h6>
<img src="images/customers-configparam.png">

<h4><b>2.Consul Config:</b></h4>
<img src="images/ConsulConfig.png">
<h4>3.Spring Cloud Gateway:</h4>
<br>
<p>Objective: Act as a gateway for routing and managing communication between microservices.</p>
<img src="images/gatewayAt4.png">
<img src="images/inventory-servicevia_gateway.png">
<h4>4.Customer-service:</h4>
<p>Objective: Manage customer-related information.</p>

<br>
<h4>5.Inventory Service:</h4>

<p>Objective: Manage product inventory and availability.</p>
<br>
<h4>6.Order Service:</h4>

<p>Objective: Manage customer orders and interactions with other services.</p>
<img src="images/order_service.png">
<br>
<img src="images/oredr_service.png">
<br>
<h4>7.Vault (Billing Service):</h4>
<img src="images/Vault.png">
<p>Objective: Secure management of sensitive billing-related information, often referred to as secrets.</p>
<br>
<h4>7.Consul and Vault Configurations</h4>
<img src="images/ConsulVaultConfig.png">
<h4>Frontend Web with Angular:</h4>
<h5>Product List</h5>
<img src="images/frontend-Product.png">
<h5>Customers</h5>
<img src="images/frontend-Customer.png">
<h5>Customer Orders : Customer 1</h5>
<img src="images/frontend-OrdersCutomer1.png">
<h5>Order Details of Customer 1</h5>
<img src="images/frontend-OrderDetails.png">






