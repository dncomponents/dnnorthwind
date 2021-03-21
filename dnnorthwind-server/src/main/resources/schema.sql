DROP SCHEMA IF EXISTS northwind;

CREATE SCHEMA northwind;
USE northwind;

DROP TABLE IF EXISTS customer_customer_demo;
DROP TABLE IF EXISTS customer_demographics;
DROP TABLE IF EXISTS employee_territories;
DROP TABLE IF EXISTS order_details;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS shippers;
DROP TABLE IF EXISTS suppliers;
DROP TABLE IF EXISTS territories;
DROP TABLE IF EXISTS us_states;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS region;
DROP TABLE IF EXISTS employees;

--
-- Name: categories; Type: TABLE; Schema: public; Owner: -; Tablespace:
--

CREATE TABLE categories
(
    category_id   smallint NOT NULL,
    category_name character varying(15) NOT NULL,
    description   text,
    picture       text
);


--
-- Name: customer_customer_demo; Type: TABLE; Schema: public; Owner: -; Tablespace:
--

CREATE TABLE customer_customer_demo
(
    customer_id      integer   NOT NULL,
    customer_type_id CHARACTER NOT NULL
);


--
-- Name: customer_demographics; Type: TABLE; Schema: public; Owner: -; Tablespace:
--

CREATE TABLE customer_demographics
(
    customer_type_id CHARACTER NOT NULL,
    customer_desc    text
);


--
-- Name: customers; Type: TABLE; Schema: public; Owner: -; Tablespace:
--

CREATE TABLE customers
(
    customer_id   integer auto_increment NOT NULL,
    company_name  character varying(40) NOT NULL,
    contact_name  character varying(30),
    contact_title character varying(30),
    address       character varying(60),
    city          character varying(15),
    region        character varying(15),
    postal_code   character varying(10),
    country       character varying(15),
    phone         character varying(24),
    email         character varying(24)
);


--
-- Name: employees; Type: TABLE; Schema: public; Owner: -; Tablespace:
--

CREATE TABLE employees
(
    employee_id       integer auto_increment NOT NULL,
    last_name         character varying(20) NOT NULL,
    first_name        character varying(10) NOT NULL,
    title             character varying(30),
    title_of_courtesy character varying(25),
    birth_date        date,
    hire_date         date,
    address           character varying(60),
    city              character varying(15),
    region            character varying(15),
    postal_code       character varying(10),
    country           character varying(15),
    home_phone        character varying(24),
    extension         character varying(4),
    photo             character,
    notes             text,
    reports_to        smallint
);


--
-- Name: employee_territories; Type: TABLE; Schema: public; Owner: -; Tablespace:
--

CREATE TABLE employee_territories
(
    employee_id  smallint NOT NULL,
    territory_id character varying(20) NOT NULL
);



--
-- Name: order_details; Type: TABLE; Schema: public; Owner: -; Tablespace:
--

CREATE TABLE order_details
(
    order_id   smallint NOT NULL,
    product_id smallint NOT NULL,
    unit_price real     NOT NULL,
    quantity   smallint NOT NULL,
    discount   real     NOT NULL
);


--
-- Name: orders; Type: TABLE; Schema: public; Owner: -; Tablespace:
--

CREATE TABLE orders
(
    order_id         integer auto_increment NOT NULL,
    customer_id      integer,
    employee_id      smallint,
    order_date       date,
    required_date    date,
    shipped_date     date,
    ship_via         smallint,
    freight          real,
    ship_name        character varying(40),
    ship_address     character varying(60),
    ship_city        character varying(15),
    ship_region      character varying(15),
    ship_postal_code character varying(10),
    ship_country     character varying(15)
);


--
-- Name: products; Type: TABLE; Schema: public; Owner: -; Tablespace:
--

CREATE TABLE products
(
    product_id        integer auto_increment NOT NULL,
    product_name      character varying(40) NOT NULL,
    supplier_id       smallint,
    category_id       smallint,
    quantity_per_unit character varying(20),
    unit_price        real,
    units_in_stock    smallint,
    units_on_order    smallint,
    reorder_level     smallint,
    discontinued      integer                NOT NULL
);


--
-- Name: region; Type: TABLE; Schema: public; Owner: -; Tablespace:
--

CREATE TABLE region
(
    region_id          smallint  NOT NULL,
    region_description CHARACTER NOT NULL
);


--
-- Name: shippers; Type: TABLE; Schema: public; Owner: -; Tablespace:
--

CREATE TABLE shippers
(
    shipper_id   smallint NOT NULL,
    company_name character varying(40) NOT NULL,
    phone        character varying(24)
);



--
-- Name: suppliers; Type: TABLE; Schema: public; Owner: -; Tablespace:
--

CREATE TABLE suppliers
(
    supplier_id   integer auto_increment NOT NULL,
    company_name  character varying(40) NOT NULL,
    contact_name  character varying(30),
    contact_title character varying(30),
    address       character varying(60),
    city          character varying(15),
    region        character varying(15),
    postal_code   character varying(10),
    country       character varying(15),
    phone         character varying(24),
    email         character varying(24),
    homepage      text
);


--
-- Name: territories; Type: TABLE; Schema: public; Owner: -; Tablespace:
--

CREATE TABLE territories
(
    territory_id          character varying(20) NOT NULL,
    territory_description CHARACTER NOT NULL,
    region_id             smallint  NOT NULL
);


--
-- Name: us_states; Type: TABLE; Schema: public; Owner: -; Tablespace:
--

CREATE TABLE us_states
(
    state_id     smallint NOT NULL,
    state_name   character varying(100),
    state_abbr   character varying(2),
    state_region character varying(50)
);

