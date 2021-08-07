--
-- PostgreSQL database dump
--

-- Dumped from database version 13.3 (Debian 13.3-1.pgdg100+1)
-- Dumped by pg_dump version 13.3

-- Started on 2021-08-06 00:32:13 CEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE fitnesskcalc;
--
-- TOC entry 3037 (class 1262 OID 16404)
-- Name: fitnesskcalc; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE fitnesskcalc WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.utf8';


ALTER DATABASE fitnesskcalc OWNER TO postgres;

\connect fitnesskcalc

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 206 (class 1259 OID 16451)
-- Name: foods; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.foods (
    id bigint NOT NULL,
    name character varying,
    ingredients integer[]
);


ALTER TABLE public.foods OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 16449)
-- Name: foods_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.foods_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.foods_id_seq OWNER TO postgres;

--
-- TOC entry 3038 (class 0 OID 0)
-- Dependencies: 205
-- Name: foods_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.foods_id_seq OWNED BY public.foods.id;


--
-- TOC entry 211 (class 1259 OID 16517)
-- Name: goals; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.goals (
    id integer NOT NULL,
    user_id integer NOT NULL,
    kcal integer,
    proteins integer,
    carbohydrates integer,
    fats integer
);


ALTER TABLE public.goals OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 16527)
-- Name: goals_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.goals ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.goals_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 204 (class 1259 OID 16438)
-- Name: ingredients; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ingredients (
    id bigint NOT NULL,
    name character varying,
    proteins integer,
    fats integer,
    carbohydrates integer
);


ALTER TABLE public.ingredients OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16436)
-- Name: ingredients_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ingredients_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ingredients_id_seq OWNER TO postgres;

--
-- TOC entry 3039 (class 0 OID 0)
-- Dependencies: 203
-- Name: ingredients_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ingredients_id_seq OWNED BY public.ingredients.id;


--
-- TOC entry 212 (class 1259 OID 16522)
-- Name: meals; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.meals (
    id integer NOT NULL,
    user_id integer NOT NULL,
    date date NOT NULL,
    meal1 integer[],
    meal2 integer[],
    meal3 integer[],
    meal4 integer[],
    meal5 integer[]
);


ALTER TABLE public.meals OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 16529)
-- Name: meals_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.meals ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.meals_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 208 (class 1259 OID 16486)
-- Name: profiles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.profiles (
    id integer NOT NULL,
    age integer,
    height integer,
    user_id integer NOT NULL
);


ALTER TABLE public.profiles OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 16484)
-- Name: profile_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.profile_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.profile_id_seq OWNER TO postgres;

--
-- TOC entry 3040 (class 0 OID 0)
-- Dependencies: 207
-- Name: profile_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.profile_id_seq OWNED BY public.profiles.id;


--
-- TOC entry 202 (class 1259 OID 16419)
-- Name: settings; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.settings (
    key character varying NOT NULL,
    value character varying,
    user_id integer NOT NULL
);


ALTER TABLE public.settings OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16405)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    username character varying(30) NOT NULL,
    password character varying NOT NULL,
    email character varying(255) NOT NULL,
    role character varying(30)
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16417)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.users ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.users_id_seq
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 209 (class 1259 OID 16510)
-- Name: weights; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.weights (
    id integer NOT NULL,
    user_id integer NOT NULL,
    date date NOT NULL,
    weight real NOT NULL
);


ALTER TABLE public.weights OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16515)
-- Name: weights_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.weights ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.weights_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 2850 (class 2604 OID 16454)
-- Name: foods id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.foods ALTER COLUMN id SET DEFAULT nextval('public.foods_id_seq'::regclass);


--
-- TOC entry 2849 (class 2604 OID 16441)
-- Name: ingredients id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ingredients ALTER COLUMN id SET DEFAULT nextval('public.ingredients_id_seq'::regclass);


--
-- TOC entry 2851 (class 2604 OID 16495)
-- Name: profiles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profiles ALTER COLUMN id SET DEFAULT nextval('public.profile_id_seq'::regclass);


--
-- TOC entry 3023 (class 0 OID 16451)
-- Dependencies: 206
-- Data for Name: foods; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.foods (id, name, ingredients) VALUES (3, 'Pizza con queso', '{1}');
INSERT INTO public.foods (id, name, ingredients) VALUES (4, 'Pizza doble de queso', '{1,1}');
INSERT INTO public.foods (id, name, ingredients) VALUES (5, 'Pizza con pina', '{1}');
INSERT INTO public.foods (id, name, ingredients) VALUES (6, 'Pizza de avena', '{1}');
INSERT INTO public.foods (id, name, ingredients) VALUES (1, 'Pizza 4 Quesos', '{1,1,1,1}');


--
-- TOC entry 3028 (class 0 OID 16517)
-- Dependencies: 211
-- Data for Name: goals; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.goals (id, user_id, kcal, proteins, carbohydrates, fats) OVERRIDING SYSTEM VALUE VALUES (1, 1, 3100, 30, 35, 40);


--
-- TOC entry 3021 (class 0 OID 16438)
-- Dependencies: 204
-- Data for Name: ingredients; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.ingredients (id, name, proteins, fats, carbohydrates) VALUES (2, 'Patata', 15, 5, 80);
INSERT INTO public.ingredients (id, name, proteins, fats, carbohydrates) VALUES (4, 'Atun', 20, 20, 20);
INSERT INTO public.ingredients (id, name, proteins, fats, carbohydrates) VALUES (5, 'Tomate', 1, 1, 1);
INSERT INTO public.ingredients (id, name, proteins, fats, carbohydrates) VALUES (6, 'Lechuga', 1, 1, 1);
INSERT INTO public.ingredients (id, name, proteins, fats, carbohydrates) VALUES (7, 'Fresa', 10, 10, 10);
INSERT INTO public.ingredients (id, name, proteins, fats, carbohydrates) VALUES (3, 'Salta tomate', 22, 22, 22);
INSERT INTO public.ingredients (id, name, proteins, fats, carbohydrates) VALUES (10, 'Maiz', 1, 1, 1);
INSERT INTO public.ingredients (id, name, proteins, fats, carbohydrates) VALUES (1, 'Queso', 1, 1, 1);
INSERT INTO public.ingredients (id, name, proteins, fats, carbohydrates) VALUES (15, 'Avena', 1, 1, 4);
INSERT INTO public.ingredients (id, name, proteins, fats, carbohydrates) VALUES (16, 'Chocolato', 1, 2, 1);


--
-- TOC entry 3029 (class 0 OID 16522)
-- Dependencies: 212
-- Data for Name: meals; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.meals (id, user_id, date, meal1, meal2, meal3, meal4, meal5) OVERRIDING SYSTEM VALUE VALUES (8, 1, '2021-07-30', '{4,1,6,6,1,4,4,3,1,1,1,1,1,1,1}', '{4,1,6,6,1,4,4,3,5,6}', '{4,1,6,6,1,4,6,6,3,1,1,1,1,1,1,1,1,1}', '{4,1,6,6,1,4,4,3,5,5,5,5,5,5}', '{1,1,1,3,4,5,6,4,1,6,6,1,4,4,3}');
INSERT INTO public.meals (id, user_id, date, meal1, meal2, meal3, meal4, meal5) OVERRIDING SYSTEM VALUE VALUES (9, 1, '2021-07-31', '{1,1}', '{1}', '{1}', '{1}', '{1}');
INSERT INTO public.meals (id, user_id, date, meal1, meal2, meal3, meal4, meal5) OVERRIDING SYSTEM VALUE VALUES (17, 1, '2021-08-04', '{1}', '{}', '{}', '{}', '{}');
INSERT INTO public.meals (id, user_id, date, meal1, meal2, meal3, meal4, meal5) OVERRIDING SYSTEM VALUE VALUES (18, 1, '2021-08-05', '{6}', '{}', '{}', '{}', '{}');
INSERT INTO public.meals (id, user_id, date, meal1, meal2, meal3, meal4, meal5) OVERRIDING SYSTEM VALUE VALUES (10, 1, '2021-08-01', '{6,6}', '{1}', '{1}', '{1}', '{1}');
INSERT INTO public.meals (id, user_id, date, meal1, meal2, meal3, meal4, meal5) OVERRIDING SYSTEM VALUE VALUES (11, 1, '2021-08-03', '{4,1,6,6,6}', '{1,6}', '{4,6,1}', '{4}', '{1}');


--
-- TOC entry 3025 (class 0 OID 16486)
-- Dependencies: 208
-- Data for Name: profiles; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.profiles (id, age, height, user_id) VALUES (2, 33, 177, 1);


--
-- TOC entry 3019 (class 0 OID 16419)
-- Dependencies: 202
-- Data for Name: settings; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.settings (key, value, user_id) VALUES ('meal3', 'merienda', 1);
INSERT INTO public.settings (key, value, user_id) VALUES ('meal1', 'desayuno', 1);
INSERT INTO public.settings (key, value, user_id) VALUES ('meal2', 'almuerzo', 1);
INSERT INTO public.settings (key, value, user_id) VALUES ('meal5', 'aperitivos', 1);
INSERT INTO public.settings (key, value, user_id) VALUES ('meal4', 'cena', 1);


--
-- TOC entry 3017 (class 0 OID 16405)
-- Dependencies: 200
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users (id, username, password, email, role) OVERRIDING SYSTEM VALUE VALUES (1, 'demo', '$2a$10$9lcy2p3bRvYK0yWB.R0KM.IdJjs62Asuw1BJqdl/F.z8/0U2uud7i', 'demo@gmail.com', 'USER');


--
-- TOC entry 3026 (class 0 OID 16510)
-- Dependencies: 209
-- Data for Name: weights; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.weights (id, user_id, date, weight) VALUES (1, 1, '2021-07-21', 66.2);
INSERT INTO public.weights (id, user_id, date, weight) VALUES (2, 1, '2021-07-22', 66.6);
INSERT INTO public.weights (id, user_id, date, weight) VALUES (3, 1, '2021-07-23', 67.01);
INSERT INTO public.weights (id, user_id, date, weight) VALUES (4, 1, '2021-07-24', 67.55);
INSERT INTO public.weights (id, user_id, date, weight) VALUES (5, 1, '2021-07-26', 67.77);
INSERT INTO public.weights (id, user_id, date, weight) VALUES (6, 1, '2021-07-27', 68);
INSERT INTO public.weights (id, user_id, date, weight) VALUES (7, 1, '2021-07-28', 68.2);
INSERT INTO public.weights (id, user_id, date, weight) VALUES (8, 1, '2021-07-29', 68.5);
INSERT INTO public.weights (id, user_id, date, weight) VALUES (11, 1, '2021-07-30', 55);
INSERT INTO public.weights (id, user_id, date, weight) VALUES (12, 1, '2021-07-31', 70);
INSERT INTO public.weights (id, user_id, date, weight) VALUES (13, 1, '2021-08-01', 55);
INSERT INTO public.weights (id, user_id, date, weight) VALUES (14, 1, '2021-08-02', 66);
INSERT INTO public.weights (id, user_id, date, weight) VALUES (15, 1, '2021-08-03', 77);
INSERT INTO public.weights (id, user_id, date, weight) VALUES (22, 1, '2021-08-04', 77);
INSERT INTO public.weights (id, user_id, date, weight) VALUES (23, 1, '2021-08-05', 57);


--
-- TOC entry 3041 (class 0 OID 0)
-- Dependencies: 205
-- Name: foods_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.foods_id_seq', 10, true);


--
-- TOC entry 3042 (class 0 OID 0)
-- Dependencies: 213
-- Name: goals_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.goals_id_seq', 6, true);


--
-- TOC entry 3043 (class 0 OID 0)
-- Dependencies: 203
-- Name: ingredients_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ingredients_id_seq', 20, true);


--
-- TOC entry 3044 (class 0 OID 0)
-- Dependencies: 214
-- Name: meals_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.meals_id_seq', 18, true);


--
-- TOC entry 3045 (class 0 OID 0)
-- Dependencies: 207
-- Name: profile_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.profile_id_seq', 4, true);


--
-- TOC entry 3046 (class 0 OID 0)
-- Dependencies: 201
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 3, true);


--
-- TOC entry 3047 (class 0 OID 0)
-- Dependencies: 210
-- Name: weights_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.weights_id_seq', 23, true);


--
-- TOC entry 2853 (class 2606 OID 16416)
-- Name: users email_uniq; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT email_uniq UNIQUE (email);


--
-- TOC entry 2865 (class 2606 OID 16459)
-- Name: foods food_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.foods
    ADD CONSTRAINT food_pk PRIMARY KEY (id);


--
-- TOC entry 2877 (class 2606 OID 16521)
-- Name: goals goals_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.goals
    ADD CONSTRAINT goals_pkey PRIMARY KEY (id);


--
-- TOC entry 2861 (class 2606 OID 16446)
-- Name: ingredients ingredient_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ingredients
    ADD CONSTRAINT ingredient_pk PRIMARY KEY (id);


--
-- TOC entry 2881 (class 2606 OID 16526)
-- Name: meals meals_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.meals
    ADD CONSTRAINT meals_pkey PRIMARY KEY (id);


--
-- TOC entry 2859 (class 2606 OID 16426)
-- Name: settings pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.settings
    ADD CONSTRAINT pk PRIMARY KEY (key);


--
-- TOC entry 2869 (class 2606 OID 16497)
-- Name: profiles profile_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profiles
    ADD CONSTRAINT profile_pk PRIMARY KEY (id);


--
-- TOC entry 2879 (class 2606 OID 16550)
-- Name: goals profile_uniq; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.goals
    ADD CONSTRAINT profile_uniq UNIQUE (user_id);


--
-- TOC entry 2867 (class 2606 OID 16461)
-- Name: foods uniq_food; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.foods
    ADD CONSTRAINT uniq_food UNIQUE (name);


--
-- TOC entry 2863 (class 2606 OID 16448)
-- Name: ingredients uniq_name; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ingredients
    ADD CONSTRAINT uniq_name UNIQUE (name);


--
-- TOC entry 2873 (class 2606 OID 16581)
-- Name: weights uniq_user_date; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.weights
    ADD CONSTRAINT uniq_user_date UNIQUE (user_id, date);


--
-- TOC entry 2871 (class 2606 OID 16552)
-- Name: profiles user_uniq; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profiles
    ADD CONSTRAINT user_uniq UNIQUE (user_id);


--
-- TOC entry 2855 (class 2606 OID 16414)
-- Name: users username_uniq; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT username_uniq UNIQUE (username);


--
-- TOC entry 2857 (class 2606 OID 16412)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2875 (class 2606 OID 16514)
-- Name: weights weights_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.weights
    ADD CONSTRAINT weights_pkey PRIMARY KEY (id);


--
-- TOC entry 2883 (class 2606 OID 16505)
-- Name: profiles user_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profiles
    ADD CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 2882 (class 2606 OID 16553)
-- Name: settings user_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.settings
    ADD CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 2886 (class 2606 OID 16565)
-- Name: meals user_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.meals
    ADD CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 2885 (class 2606 OID 16570)
-- Name: goals user_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.goals
    ADD CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 2884 (class 2606 OID 16575)
-- Name: weights user_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.weights
    ADD CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;


-- Completed on 2021-08-06 00:32:14 CEST

--
-- PostgreSQL database dump complete
--

