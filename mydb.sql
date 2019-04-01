--
-- PostgreSQL database dump
--

-- Dumped from database version 11.2 (Ubuntu 11.2-1.pgdg18.04+1)
-- Dumped by pg_dump version 11.2 (Ubuntu 11.2-1.pgdg18.04+1)

-- Started on 2019-04-01 11:15:36 EEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 3027 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 198 (class 1259 OID 33917)
-- Name: bought_part; Type: TABLE; Schema: public; Owner: myuser
--

CREATE TABLE public.bought_part (
    id bigint NOT NULL,
    cost character varying(255),
    car_id bigint,
    part_id bigint
);


ALTER TABLE public.bought_part OWNER TO myuser;

--
-- TOC entry 197 (class 1259 OID 33915)
-- Name: bought_part_id_seq; Type: SEQUENCE; Schema: public; Owner: myuser
--

CREATE SEQUENCE public.bought_part_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.bought_part_id_seq OWNER TO myuser;

--
-- TOC entry 3028 (class 0 OID 0)
-- Dependencies: 197
-- Name: bought_part_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: myuser
--

ALTER SEQUENCE public.bought_part_id_seq OWNED BY public.bought_part.id;


--
-- TOC entry 200 (class 1259 OID 33925)
-- Name: car; Type: TABLE; Schema: public; Owner: myuser
--

CREATE TABLE public.car (
    id bigint NOT NULL,
    miles character varying(255),
    number character varying(255),
    vin_code character varying(255),
    year character varying(255),
    model_id bigint
);


ALTER TABLE public.car OWNER TO myuser;

--
-- TOC entry 199 (class 1259 OID 33923)
-- Name: car_id_seq; Type: SEQUENCE; Schema: public; Owner: myuser
--

CREATE SEQUENCE public.car_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.car_id_seq OWNER TO myuser;

--
-- TOC entry 3029 (class 0 OID 0)
-- Dependencies: 199
-- Name: car_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: myuser
--

ALTER SEQUENCE public.car_id_seq OWNED BY public.car.id;


--
-- TOC entry 202 (class 1259 OID 33936)
-- Name: client; Type: TABLE; Schema: public; Owner: myuser
--

CREATE TABLE public.client (
    id bigint NOT NULL,
    name character varying(255),
    phone_number character varying(255)
);


ALTER TABLE public.client OWNER TO myuser;

--
-- TOC entry 201 (class 1259 OID 33934)
-- Name: client_id_seq; Type: SEQUENCE; Schema: public; Owner: myuser
--

CREATE SEQUENCE public.client_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.client_id_seq OWNER TO myuser;

--
-- TOC entry 3030 (class 0 OID 0)
-- Dependencies: 201
-- Name: client_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: myuser
--

ALTER SEQUENCE public.client_id_seq OWNED BY public.client.id;


--
-- TOC entry 196 (class 1259 OID 25151)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: myuser
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO myuser;

--
-- TOC entry 204 (class 1259 OID 33947)
-- Name: make; Type: TABLE; Schema: public; Owner: myuser
--

CREATE TABLE public.make (
    id bigint NOT NULL,
    make_name character varying(255)
);


ALTER TABLE public.make OWNER TO myuser;

--
-- TOC entry 203 (class 1259 OID 33945)
-- Name: make_id_seq; Type: SEQUENCE; Schema: public; Owner: myuser
--

CREATE SEQUENCE public.make_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.make_id_seq OWNER TO myuser;

--
-- TOC entry 3031 (class 0 OID 0)
-- Dependencies: 203
-- Name: make_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: myuser
--

ALTER SEQUENCE public.make_id_seq OWNED BY public.make.id;


--
-- TOC entry 206 (class 1259 OID 33955)
-- Name: model; Type: TABLE; Schema: public; Owner: myuser
--

CREATE TABLE public.model (
    id bigint NOT NULL,
    model_name character varying(255),
    make_id bigint
);


ALTER TABLE public.model OWNER TO myuser;

--
-- TOC entry 205 (class 1259 OID 33953)
-- Name: model_id_seq; Type: SEQUENCE; Schema: public; Owner: myuser
--

CREATE SEQUENCE public.model_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.model_id_seq OWNER TO myuser;

--
-- TOC entry 3032 (class 0 OID 0)
-- Dependencies: 205
-- Name: model_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: myuser
--

ALTER SEQUENCE public.model_id_seq OWNED BY public.model.id;


--
-- TOC entry 208 (class 1259 OID 33963)
-- Name: order_client; Type: TABLE; Schema: public; Owner: myuser
--

CREATE TABLE public.order_client (
    id bigint NOT NULL,
    done_work text,
    order_date date,
    parts_cost integer,
    status character varying(255),
    total_cost integer,
    work_cost integer,
    car_id bigint,
    client_id bigint
);


ALTER TABLE public.order_client OWNER TO myuser;

--
-- TOC entry 207 (class 1259 OID 33961)
-- Name: order_client_id_seq; Type: SEQUENCE; Schema: public; Owner: myuser
--

CREATE SEQUENCE public.order_client_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.order_client_id_seq OWNER TO myuser;

--
-- TOC entry 3033 (class 0 OID 0)
-- Dependencies: 207
-- Name: order_client_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: myuser
--

ALTER SEQUENCE public.order_client_id_seq OWNED BY public.order_client.id;


--
-- TOC entry 210 (class 1259 OID 33974)
-- Name: part; Type: TABLE; Schema: public; Owner: myuser
--

CREATE TABLE public.part (
    id bigint NOT NULL,
    cost character varying(255),
    name character varying(255)
);


ALTER TABLE public.part OWNER TO myuser;

--
-- TOC entry 209 (class 1259 OID 33972)
-- Name: part_id_seq; Type: SEQUENCE; Schema: public; Owner: myuser
--

CREATE SEQUENCE public.part_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.part_id_seq OWNER TO myuser;

--
-- TOC entry 3034 (class 0 OID 0)
-- Dependencies: 209
-- Name: part_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: myuser
--

ALTER SEQUENCE public.part_id_seq OWNED BY public.part.id;


--
-- TOC entry 212 (class 1259 OID 34016)
-- Name: user_admin; Type: TABLE; Schema: public; Owner: myuser
--

CREATE TABLE public.user_admin (
    id bigint NOT NULL,
    password character varying(255),
    user_name character varying(255)
);


ALTER TABLE public.user_admin OWNER TO myuser;

--
-- TOC entry 211 (class 1259 OID 34014)
-- Name: user_admin_id_seq; Type: SEQUENCE; Schema: public; Owner: myuser
--

CREATE SEQUENCE public.user_admin_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_admin_id_seq OWNER TO myuser;

--
-- TOC entry 3035 (class 0 OID 0)
-- Dependencies: 211
-- Name: user_admin_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: myuser
--

ALTER SEQUENCE public.user_admin_id_seq OWNED BY public.user_admin.id;


--
-- TOC entry 2854 (class 2604 OID 33920)
-- Name: bought_part id; Type: DEFAULT; Schema: public; Owner: myuser
--

ALTER TABLE ONLY public.bought_part ALTER COLUMN id SET DEFAULT nextval('public.bought_part_id_seq'::regclass);


--
-- TOC entry 2855 (class 2604 OID 33928)
-- Name: car id; Type: DEFAULT; Schema: public; Owner: myuser
--

ALTER TABLE ONLY public.car ALTER COLUMN id SET DEFAULT nextval('public.car_id_seq'::regclass);


--
-- TOC entry 2856 (class 2604 OID 33939)
-- Name: client id; Type: DEFAULT; Schema: public; Owner: myuser
--

ALTER TABLE ONLY public.client ALTER COLUMN id SET DEFAULT nextval('public.client_id_seq'::regclass);


--
-- TOC entry 2857 (class 2604 OID 33950)
-- Name: make id; Type: DEFAULT; Schema: public; Owner: myuser
--

ALTER TABLE ONLY public.make ALTER COLUMN id SET DEFAULT nextval('public.make_id_seq'::regclass);


--
-- TOC entry 2858 (class 2604 OID 33958)
-- Name: model id; Type: DEFAULT; Schema: public; Owner: myuser
--

ALTER TABLE ONLY public.model ALTER COLUMN id SET DEFAULT nextval('public.model_id_seq'::regclass);


--
-- TOC entry 2859 (class 2604 OID 33966)
-- Name: order_client id; Type: DEFAULT; Schema: public; Owner: myuser
--

ALTER TABLE ONLY public.order_client ALTER COLUMN id SET DEFAULT nextval('public.order_client_id_seq'::regclass);


--
-- TOC entry 2860 (class 2604 OID 33977)
-- Name: part id; Type: DEFAULT; Schema: public; Owner: myuser
--

ALTER TABLE ONLY public.part ALTER COLUMN id SET DEFAULT nextval('public.part_id_seq'::regclass);


--
-- TOC entry 2861 (class 2604 OID 34019)
-- Name: user_admin id; Type: DEFAULT; Schema: public; Owner: myuser
--

ALTER TABLE ONLY public.user_admin ALTER COLUMN id SET DEFAULT nextval('public.user_admin_id_seq'::regclass);


--
-- TOC entry 3007 (class 0 OID 33917)
-- Dependencies: 198
-- Data for Name: bought_part; Type: TABLE DATA; Schema: public; Owner: myuser
--

COPY public.bought_part (id, cost, car_id, part_id) FROM stdin;
1	1000	3	1
2	1000	3	1
3	500	3	2
4	5000	10	3
\.


--
-- TOC entry 3009 (class 0 OID 33925)
-- Dependencies: 200
-- Data for Name: car; Type: TABLE DATA; Schema: public; Owner: myuser
--

COPY public.car (id, miles, number, vin_code, year, model_id) FROM stdin;
1	Не вказано	Не вказано	Не вказано	Не вказано	1
2	Не вказано	Не вказано	Не вказано	Не вказано	2
3	Не вказано	Не вказано	Не вказано	Не вказано	2
4	Не вказано	Не вказано	Не вказано	Не вказано	2
5	Не вказано	Не вказано	Не вказано	Не вказано	2
6	Не вказано	Не вказано	W1000	Не вказано	1
7	Не вказано	Не вказано	W5000	Не вказано	1
8	Не вказано	Не вказано	W2000	Не вказано	3
9	Не вказано	Не вказано	W3000	Не вказано	4
10	2000	12-321-32	B1000	2010	4
\.


--
-- TOC entry 3011 (class 0 OID 33936)
-- Dependencies: 202
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: myuser
--

COPY public.client (id, name, phone_number) FROM stdin;
1	Не вказано	Не вказано
2	Mirek	Sokol
\.


--
-- TOC entry 3013 (class 0 OID 33947)
-- Dependencies: 204
-- Data for Name: make; Type: TABLE DATA; Schema: public; Owner: myuser
--

COPY public.make (id, make_name) FROM stdin;
1	Не вказано
2	BMV
\.


--
-- TOC entry 3015 (class 0 OID 33955)
-- Dependencies: 206
-- Data for Name: model; Type: TABLE DATA; Schema: public; Owner: myuser
--

COPY public.model (id, model_name, make_id) FROM stdin;
1	Не вказано	1
2	X5	2
3	X7	2
4	X8	2
\.


--
-- TOC entry 3017 (class 0 OID 33963)
-- Dependencies: 208
-- Data for Name: order_client; Type: TABLE DATA; Schema: public; Owner: myuser
--

COPY public.order_client (id, done_work, order_date, parts_cost, status, total_cost, work_cost, car_id, client_id) FROM stdin;
4	Не вказано	2019-03-27	0	new	0	0	4	1
8	Не вказано	2019-03-28	0	new	0	0	7	1
7	Не вказано	2019-03-28	0	new	0	0	6	1
9	Не вказано	2019-03-28	0	new	0	0	8	1
10	Не вказано	2019-03-28	0	new	0	0	9	1
2	Не вказано	2019-03-27	2500	closed	2500	0	3	1
6	Не вказано	2019-03-28	0	closed	0	0	5	1
1	Не вказано	2019-03-27	2000	closed	2000	0	2	1
11	long txt	2019-04-01	5000	new	7000	2000	10	2
\.


--
-- TOC entry 3019 (class 0 OID 33974)
-- Dependencies: 210
-- Data for Name: part; Type: TABLE DATA; Schema: public; Owner: myuser
--

COPY public.part (id, cost, name) FROM stdin;
1	1000	Engine
2	500	Engine
3	5000	Engine
\.


--
-- TOC entry 3021 (class 0 OID 34016)
-- Dependencies: 212
-- Data for Name: user_admin; Type: TABLE DATA; Schema: public; Owner: myuser
--

COPY public.user_admin (id, password, user_name) FROM stdin;
1	$2a$10$/roQOjH/hgy8PEf/lPL1G.3aKaWmWwHC27QD1VWBtsxAKQ1mZyY46	admin
\.


--
-- TOC entry 3036 (class 0 OID 0)
-- Dependencies: 197
-- Name: bought_part_id_seq; Type: SEQUENCE SET; Schema: public; Owner: myuser
--

SELECT pg_catalog.setval('public.bought_part_id_seq', 4, true);


--
-- TOC entry 3037 (class 0 OID 0)
-- Dependencies: 199
-- Name: car_id_seq; Type: SEQUENCE SET; Schema: public; Owner: myuser
--

SELECT pg_catalog.setval('public.car_id_seq', 10, true);


--
-- TOC entry 3038 (class 0 OID 0)
-- Dependencies: 201
-- Name: client_id_seq; Type: SEQUENCE SET; Schema: public; Owner: myuser
--

SELECT pg_catalog.setval('public.client_id_seq', 2, true);


--
-- TOC entry 3039 (class 0 OID 0)
-- Dependencies: 196
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: myuser
--

SELECT pg_catalog.setval('public.hibernate_sequence', 122, true);


--
-- TOC entry 3040 (class 0 OID 0)
-- Dependencies: 203
-- Name: make_id_seq; Type: SEQUENCE SET; Schema: public; Owner: myuser
--

SELECT pg_catalog.setval('public.make_id_seq', 2, true);


--
-- TOC entry 3041 (class 0 OID 0)
-- Dependencies: 205
-- Name: model_id_seq; Type: SEQUENCE SET; Schema: public; Owner: myuser
--

SELECT pg_catalog.setval('public.model_id_seq', 4, true);


--
-- TOC entry 3042 (class 0 OID 0)
-- Dependencies: 207
-- Name: order_client_id_seq; Type: SEQUENCE SET; Schema: public; Owner: myuser
--

SELECT pg_catalog.setval('public.order_client_id_seq', 11, true);


--
-- TOC entry 3043 (class 0 OID 0)
-- Dependencies: 209
-- Name: part_id_seq; Type: SEQUENCE SET; Schema: public; Owner: myuser
--

SELECT pg_catalog.setval('public.part_id_seq', 3, true);


--
-- TOC entry 3044 (class 0 OID 0)
-- Dependencies: 211
-- Name: user_admin_id_seq; Type: SEQUENCE SET; Schema: public; Owner: myuser
--

SELECT pg_catalog.setval('public.user_admin_id_seq', 1, true);


--
-- TOC entry 2863 (class 2606 OID 33922)
-- Name: bought_part bought_part_pkey; Type: CONSTRAINT; Schema: public; Owner: myuser
--

ALTER TABLE ONLY public.bought_part
    ADD CONSTRAINT bought_part_pkey PRIMARY KEY (id);


--
-- TOC entry 2865 (class 2606 OID 33933)
-- Name: car car_pkey; Type: CONSTRAINT; Schema: public; Owner: myuser
--

ALTER TABLE ONLY public.car
    ADD CONSTRAINT car_pkey PRIMARY KEY (id);


--
-- TOC entry 2867 (class 2606 OID 33944)
-- Name: client client_pkey; Type: CONSTRAINT; Schema: public; Owner: myuser
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id);


--
-- TOC entry 2869 (class 2606 OID 33952)
-- Name: make make_pkey; Type: CONSTRAINT; Schema: public; Owner: myuser
--

ALTER TABLE ONLY public.make
    ADD CONSTRAINT make_pkey PRIMARY KEY (id);


--
-- TOC entry 2871 (class 2606 OID 33960)
-- Name: model model_pkey; Type: CONSTRAINT; Schema: public; Owner: myuser
--

ALTER TABLE ONLY public.model
    ADD CONSTRAINT model_pkey PRIMARY KEY (id);


--
-- TOC entry 2873 (class 2606 OID 33971)
-- Name: order_client order_client_pkey; Type: CONSTRAINT; Schema: public; Owner: myuser
--

ALTER TABLE ONLY public.order_client
    ADD CONSTRAINT order_client_pkey PRIMARY KEY (id);


--
-- TOC entry 2875 (class 2606 OID 33982)
-- Name: part part_pkey; Type: CONSTRAINT; Schema: public; Owner: myuser
--

ALTER TABLE ONLY public.part
    ADD CONSTRAINT part_pkey PRIMARY KEY (id);


--
-- TOC entry 2877 (class 2606 OID 34024)
-- Name: user_admin user_admin_pkey; Type: CONSTRAINT; Schema: public; Owner: myuser
--

ALTER TABLE ONLY public.user_admin
    ADD CONSTRAINT user_admin_pkey PRIMARY KEY (id);


--
-- TOC entry 2879 (class 2606 OID 33988)
-- Name: bought_part fk246phtsbowami5wf69ojmgq73; Type: FK CONSTRAINT; Schema: public; Owner: myuser
--

ALTER TABLE ONLY public.bought_part
    ADD CONSTRAINT fk246phtsbowami5wf69ojmgq73 FOREIGN KEY (part_id) REFERENCES public.part(id);


--
-- TOC entry 2880 (class 2606 OID 33993)
-- Name: car fk772uqy9hm5yicyxh9t6x6vusr; Type: FK CONSTRAINT; Schema: public; Owner: myuser
--

ALTER TABLE ONLY public.car
    ADD CONSTRAINT fk772uqy9hm5yicyxh9t6x6vusr FOREIGN KEY (model_id) REFERENCES public.model(id);


--
-- TOC entry 2882 (class 2606 OID 34003)
-- Name: order_client fkaq3m3yqguymjcthtcrg0dovv1; Type: FK CONSTRAINT; Schema: public; Owner: myuser
--

ALTER TABLE ONLY public.order_client
    ADD CONSTRAINT fkaq3m3yqguymjcthtcrg0dovv1 FOREIGN KEY (car_id) REFERENCES public.car(id);


--
-- TOC entry 2881 (class 2606 OID 33998)
-- Name: model fkfvdrvechg4dtwo64ut3g01hu4; Type: FK CONSTRAINT; Schema: public; Owner: myuser
--

ALTER TABLE ONLY public.model
    ADD CONSTRAINT fkfvdrvechg4dtwo64ut3g01hu4 FOREIGN KEY (make_id) REFERENCES public.make(id);


--
-- TOC entry 2883 (class 2606 OID 34008)
-- Name: order_client fki16gr0wu5yjr3gjfph4sr5ln3; Type: FK CONSTRAINT; Schema: public; Owner: myuser
--

ALTER TABLE ONLY public.order_client
    ADD CONSTRAINT fki16gr0wu5yjr3gjfph4sr5ln3 FOREIGN KEY (client_id) REFERENCES public.client(id);


--
-- TOC entry 2878 (class 2606 OID 33983)
-- Name: bought_part fkqswoxkq8quy5cnfqrgogkprml; Type: FK CONSTRAINT; Schema: public; Owner: myuser
--

ALTER TABLE ONLY public.bought_part
    ADD CONSTRAINT fkqswoxkq8quy5cnfqrgogkprml FOREIGN KEY (car_id) REFERENCES public.car(id);


-- Completed on 2019-04-01 11:15:36 EEST

--
-- PostgreSQL database dump complete
--

