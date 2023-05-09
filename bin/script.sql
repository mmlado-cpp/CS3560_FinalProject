--
-- PostgreSQL database dump
--

-- Dumped from database version 15.1
-- Dumped by pg_dump version 15.1

-- Started on 2023-05-09 16:29:02

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
-- TOC entry 214 (class 1259 OID 24717)
-- Name: author; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.author (
    author_id integer NOT NULL,
    name text,
    book_id integer,
    subject text,
    nationality text
);


ALTER TABLE public.author OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 24722)
-- Name: author_author_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.author_author_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.author_author_id_seq OWNER TO postgres;

--
-- TOC entry 3380 (class 0 OID 0)
-- Dependencies: 215
-- Name: author_author_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.author_author_id_seq OWNED BY public.author.author_id;


--
-- TOC entry 216 (class 1259 OID 24723)
-- Name: book; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.book (
    item_id integer NOT NULL,
    number_pages integer,
    publisher text,
    publication_date date
);


ALTER TABLE public.book OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 24799)
-- Name: book_author; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.book_author (
    author_id integer NOT NULL,
    item_id integer NOT NULL
);


ALTER TABLE public.book_author OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 24728)
-- Name: book_book_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.book_book_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.book_book_id_seq OWNER TO postgres;

--
-- TOC entry 3381 (class 0 OID 0)
-- Dependencies: 217
-- Name: book_book_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.book_book_id_seq OWNED BY public.book.item_id;


--
-- TOC entry 218 (class 1259 OID 24729)
-- Name: documentary; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.documentary (
    item_id integer NOT NULL,
    director text,
    length integer,
    release_date text
);


ALTER TABLE public.documentary OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 24734)
-- Name: documentary_documentary_producer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.documentary_documentary_producer (
    item_id integer NOT NULL,
    producer_id integer NOT NULL
);


ALTER TABLE public.documentary_documentary_producer OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 24737)
-- Name: documentary_item_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.documentary_item_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.documentary_item_id_seq OWNER TO postgres;

--
-- TOC entry 3382 (class 0 OID 0)
-- Dependencies: 220
-- Name: documentary_item_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.documentary_item_id_seq OWNED BY public.documentary.item_id;


--
-- TOC entry 221 (class 1259 OID 24738)
-- Name: documentary_producer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.documentary_producer (
    producer_id integer NOT NULL,
    name text,
    email text,
    style text,
    nationality text
);


ALTER TABLE public.documentary_producer OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 24743)
-- Name: documentary_producer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.documentary_producer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.documentary_producer_id_seq OWNER TO postgres;

--
-- TOC entry 3383 (class 0 OID 0)
-- Dependencies: 222
-- Name: documentary_producer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.documentary_producer_id_seq OWNED BY public.documentary_producer.producer_id;


--
-- TOC entry 223 (class 1259 OID 24744)
-- Name: item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.item (
    item_id integer NOT NULL,
    available boolean,
    title text,
    description text,
    location text,
    daily_price double precision
);


ALTER TABLE public.item OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 24749)
-- Name: item_item_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.item_item_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.item_item_id_seq OWNER TO postgres;

--
-- TOC entry 3384 (class 0 OID 0)
-- Dependencies: 224
-- Name: item_item_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.item_item_id_seq OWNED BY public.item.item_id;


--
-- TOC entry 225 (class 1259 OID 24750)
-- Name: student; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.student (
    bronco_id integer NOT NULL,
    name text,
    course text,
    email text
);


ALTER TABLE public.student OWNER TO postgres;

--
-- TOC entry 3205 (class 2604 OID 24755)
-- Name: author author_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.author ALTER COLUMN author_id SET DEFAULT nextval('public.author_author_id_seq'::regclass);


--
-- TOC entry 3206 (class 2604 OID 24756)
-- Name: book item_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book ALTER COLUMN item_id SET DEFAULT nextval('public.book_book_id_seq'::regclass);


--
-- TOC entry 3207 (class 2604 OID 24757)
-- Name: documentary item_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.documentary ALTER COLUMN item_id SET DEFAULT nextval('public.documentary_item_id_seq'::regclass);


--
-- TOC entry 3208 (class 2604 OID 24758)
-- Name: documentary_producer producer_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.documentary_producer ALTER COLUMN producer_id SET DEFAULT nextval('public.documentary_producer_id_seq'::regclass);


--
-- TOC entry 3209 (class 2604 OID 24759)
-- Name: item item_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item ALTER COLUMN item_id SET DEFAULT nextval('public.item_item_id_seq'::regclass);


--
-- TOC entry 3223 (class 2606 OID 24761)
-- Name: student Student_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT "Student_pkey" PRIMARY KEY (bronco_id);


--
-- TOC entry 3211 (class 2606 OID 24763)
-- Name: author author_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.author
    ADD CONSTRAINT author_pkey PRIMARY KEY (author_id);


--
-- TOC entry 3225 (class 2606 OID 24803)
-- Name: book_author book_author_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book_author
    ADD CONSTRAINT book_author_pk PRIMARY KEY (author_id, item_id);


--
-- TOC entry 3213 (class 2606 OID 24765)
-- Name: book book_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (item_id);


--
-- TOC entry 3215 (class 2606 OID 24767)
-- Name: documentary documentary_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.documentary
    ADD CONSTRAINT documentary_pkey PRIMARY KEY (item_id);


--
-- TOC entry 3219 (class 2606 OID 24769)
-- Name: documentary_producer documentary_producer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.documentary_producer
    ADD CONSTRAINT documentary_producer_pkey PRIMARY KEY (producer_id);


--
-- TOC entry 3217 (class 2606 OID 24771)
-- Name: documentary_documentary_producer id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.documentary_documentary_producer
    ADD CONSTRAINT id PRIMARY KEY (item_id, producer_id);


--
-- TOC entry 3221 (class 2606 OID 24773)
-- Name: item item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item
    ADD CONSTRAINT item_pkey PRIMARY KEY (item_id);


--
-- TOC entry 3231 (class 2606 OID 24809)
-- Name: book_author author_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book_author
    ADD CONSTRAINT author_id_fk FOREIGN KEY (author_id) REFERENCES public.author(author_id) NOT VALID;


--
-- TOC entry 3226 (class 2606 OID 24774)
-- Name: author fk_book_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.author
    ADD CONSTRAINT fk_book_id FOREIGN KEY (book_id) REFERENCES public.book(item_id) NOT VALID;


--
-- TOC entry 3228 (class 2606 OID 24779)
-- Name: documentary item_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.documentary
    ADD CONSTRAINT item_id_fk FOREIGN KEY (item_id) REFERENCES public.item(item_id) NOT VALID;


--
-- TOC entry 3227 (class 2606 OID 24784)
-- Name: book item_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT item_id_fk FOREIGN KEY (item_id) REFERENCES public.item(item_id) NOT VALID;


--
-- TOC entry 3229 (class 2606 OID 24789)
-- Name: documentary_documentary_producer item_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.documentary_documentary_producer
    ADD CONSTRAINT item_id_fk FOREIGN KEY (item_id) REFERENCES public.item(item_id);


--
-- TOC entry 3232 (class 2606 OID 24804)
-- Name: book_author item_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book_author
    ADD CONSTRAINT item_id_fk FOREIGN KEY (item_id) REFERENCES public.book(item_id) NOT VALID;


--
-- TOC entry 3230 (class 2606 OID 24794)
-- Name: documentary_documentary_producer producer_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.documentary_documentary_producer
    ADD CONSTRAINT producer_id_fk FOREIGN KEY (producer_id) REFERENCES public.documentary_producer(producer_id);


-- Completed on 2023-05-09 16:29:03

--
-- PostgreSQL database dump complete
--

