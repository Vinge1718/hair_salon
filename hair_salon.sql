--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.6
-- Dumped by pg_dump version 9.6.6

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: clients; Type: TABLE; Schema: public; Owner: v
--

CREATE TABLE clients (
    id integer NOT NULL,
    name character varying,
    stylistid integer
);


ALTER TABLE clients OWNER TO v;

--
-- Name: clients_id_seq; Type: SEQUENCE; Schema: public; Owner: v
--

CREATE SEQUENCE clients_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE clients_id_seq OWNER TO v;

--
-- Name: clients_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: v
--

ALTER SEQUENCE clients_id_seq OWNED BY clients.id;


--
-- Name: stylists; Type: TABLE; Schema: public; Owner: v
--

CREATE TABLE stylists (
    id integer NOT NULL,
    name character varying
);


ALTER TABLE stylists OWNER TO v;

--
-- Name: stylists_id_seq; Type: SEQUENCE; Schema: public; Owner: v
--

CREATE SEQUENCE stylists_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE stylists_id_seq OWNER TO v;

--
-- Name: stylists_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: v
--

ALTER SEQUENCE stylists_id_seq OWNED BY stylists.id;


--
-- Name: clients id; Type: DEFAULT; Schema: public; Owner: v
--

ALTER TABLE ONLY clients ALTER COLUMN id SET DEFAULT nextval('clients_id_seq'::regclass);


--
-- Name: stylists id; Type: DEFAULT; Schema: public; Owner: v
--

ALTER TABLE ONLY stylists ALTER COLUMN id SET DEFAULT nextval('stylists_id_seq'::regclass);


--
-- Data for Name: clients; Type: TABLE DATA; Schema: public; Owner: v
--

COPY clients (id, name, stylistid) FROM stdin;
\.


--
-- Name: clients_id_seq; Type: SEQUENCE SET; Schema: public; Owner: v
--

SELECT pg_catalog.setval('clients_id_seq', 6, true);


--
-- Data for Name: stylists; Type: TABLE DATA; Schema: public; Owner: v
--

COPY stylists (id, name) FROM stdin;
1	Kim
2	Dawson
\.


--
-- Name: stylists_id_seq; Type: SEQUENCE SET; Schema: public; Owner: v
--

SELECT pg_catalog.setval('stylists_id_seq', 2, true);


--
-- Name: clients clients_pkey; Type: CONSTRAINT; Schema: public; Owner: v
--

ALTER TABLE ONLY clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (id);


--
-- Name: stylists stylists_pkey; Type: CONSTRAINT; Schema: public; Owner: v
--

ALTER TABLE ONLY stylists
    ADD CONSTRAINT stylists_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

