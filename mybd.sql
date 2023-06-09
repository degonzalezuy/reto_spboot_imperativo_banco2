PGDMP             	            {            bank    15.2 (Debian 15.2-1.pgdg110+1)    15.2 "               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    24599    bank    DATABASE     o   CREATE DATABASE bank WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';
    DROP DATABASE bank;
                postgres    false            �            1259    24724    cliente    TABLE     P  CREATE TABLE public.cliente (
    id_cliente bigint NOT NULL,
    contrasena character varying(255),
    direccion character varying(255),
    documento integer NOT NULL,
    edad integer NOT NULL,
    estado boolean NOT NULL,
    genero character varying(255),
    nombre character varying(255),
    telefono character varying(255)
);
    DROP TABLE public.cliente;
       public         heap    postgres    false            �            1259    24723    cliente_id_cliente_seq    SEQUENCE        CREATE SEQUENCE public.cliente_id_cliente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.cliente_id_cliente_seq;
       public          postgres    false    217                       0    0    cliente_id_cliente_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.cliente_id_cliente_seq OWNED BY public.cliente.id_cliente;
          public          postgres    false    216            �            1259    24619    cliente_seq    SEQUENCE     u   CREATE SEQUENCE public.cliente_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.cliente_seq;
       public          postgres    false            �            1259    24744    cuenta    TABLE     �   CREATE TABLE public.cuenta (
    id_cuenta bigint NOT NULL,
    estado boolean,
    numero bigint,
    saldo real NOT NULL,
    tipo_cuenta character varying(255),
    cliente_id_cliente bigint,
    cliente_id bigint
);
    DROP TABLE public.cuenta;
       public         heap    postgres    false            �            1259    24743    cuenta_id_cuenta_seq    SEQUENCE     }   CREATE SEQUENCE public.cuenta_id_cuenta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.cuenta_id_cuenta_seq;
       public          postgres    false    220                       0    0    cuenta_id_cuenta_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.cuenta_id_cuenta_seq OWNED BY public.cuenta.id_cuenta;
          public          postgres    false    219            �            1259    24737 
   cuenta_seq    SEQUENCE     t   CREATE SEQUENCE public.cuenta_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public.cuenta_seq;
       public          postgres    false            �            1259    24620 
   genero_seq    SEQUENCE     t   CREATE SEQUENCE public.genero_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public.genero_seq;
       public          postgres    false            �            1259    24756 
   movimiento    TABLE     �   CREATE TABLE public.movimiento (
    id_movimiento bigint NOT NULL,
    fecha timestamp(6) without time zone,
    saldo real NOT NULL,
    tipo_movimiento character varying(255),
    valor real NOT NULL,
    cuenta_id_cuenta bigint
);
    DROP TABLE public.movimiento;
       public         heap    postgres    false            �            1259    24755    movimiento_id_movimiento_seq    SEQUENCE     �   CREATE SEQUENCE public.movimiento_id_movimiento_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.movimiento_id_movimiento_seq;
       public          postgres    false    222                        0    0    movimiento_id_movimiento_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.movimiento_id_movimiento_seq OWNED BY public.movimiento.id_movimiento;
          public          postgres    false    221            u           2604    24727    cliente id_cliente    DEFAULT     x   ALTER TABLE ONLY public.cliente ALTER COLUMN id_cliente SET DEFAULT nextval('public.cliente_id_cliente_seq'::regclass);
 A   ALTER TABLE public.cliente ALTER COLUMN id_cliente DROP DEFAULT;
       public          postgres    false    216    217    217            v           2604    24747    cuenta id_cuenta    DEFAULT     t   ALTER TABLE ONLY public.cuenta ALTER COLUMN id_cuenta SET DEFAULT nextval('public.cuenta_id_cuenta_seq'::regclass);
 ?   ALTER TABLE public.cuenta ALTER COLUMN id_cuenta DROP DEFAULT;
       public          postgres    false    219    220    220            w           2604    24759    movimiento id_movimiento    DEFAULT     �   ALTER TABLE ONLY public.movimiento ALTER COLUMN id_movimiento SET DEFAULT nextval('public.movimiento_id_movimiento_seq'::regclass);
 G   ALTER TABLE public.movimiento ALTER COLUMN id_movimiento DROP DEFAULT;
       public          postgres    false    221    222    222                      0    24724    cliente 
   TABLE DATA           w   COPY public.cliente (id_cliente, contrasena, direccion, documento, edad, estado, genero, nombre, telefono) FROM stdin;
    public          postgres    false    217   �&                 0    24744    cuenta 
   TABLE DATA           o   COPY public.cuenta (id_cuenta, estado, numero, saldo, tipo_cuenta, cliente_id_cliente, cliente_id) FROM stdin;
    public          postgres    false    220   h'                 0    24756 
   movimiento 
   TABLE DATA           k   COPY public.movimiento (id_movimiento, fecha, saldo, tipo_movimiento, valor, cuenta_id_cuenta) FROM stdin;
    public          postgres    false    222   �'       !           0    0    cliente_id_cliente_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.cliente_id_cliente_seq', 3, true);
          public          postgres    false    216            "           0    0    cliente_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.cliente_seq', 1, true);
          public          postgres    false    214            #           0    0    cuenta_id_cuenta_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.cuenta_id_cuenta_seq', 4, true);
          public          postgres    false    219            $           0    0 
   cuenta_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.cuenta_seq', 1, false);
          public          postgres    false    218            %           0    0 
   genero_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.genero_seq', 1, false);
          public          postgres    false    215            &           0    0    movimiento_id_movimiento_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.movimiento_id_movimiento_seq', 36, true);
          public          postgres    false    221            y           2606    24731    cliente cliente_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id_cliente);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public            postgres    false    217            {           2606    24749    cuenta cuenta_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT cuenta_pkey PRIMARY KEY (id_cuenta);
 <   ALTER TABLE ONLY public.cuenta DROP CONSTRAINT cuenta_pkey;
       public            postgres    false    220            }           2606    24761    movimiento movimiento_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.movimiento
    ADD CONSTRAINT movimiento_pkey PRIMARY KEY (id_movimiento);
 D   ALTER TABLE ONLY public.movimiento DROP CONSTRAINT movimiento_pkey;
       public            postgres    false    222            ~           2606    24750 "   cuenta fk4ejpfsimj7rgv5nr994wmstui    FK CONSTRAINT     �   ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT fk4ejpfsimj7rgv5nr994wmstui FOREIGN KEY (cliente_id_cliente) REFERENCES public.cliente(id_cliente);
 L   ALTER TABLE ONLY public.cuenta DROP CONSTRAINT fk4ejpfsimj7rgv5nr994wmstui;
       public          postgres    false    220    217    3193                       2606    32924 "   cuenta fk4p224uogyy5hmxvn8fwa2jlug    FK CONSTRAINT     �   ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT fk4p224uogyy5hmxvn8fwa2jlug FOREIGN KEY (cliente_id) REFERENCES public.cliente(id_cliente);
 L   ALTER TABLE ONLY public.cuenta DROP CONSTRAINT fk4p224uogyy5hmxvn8fwa2jlug;
       public          postgres    false    220    217    3193            �           2606    24762 &   movimiento fkd8vdh1gws7jn8sjx62m9fdfvk    FK CONSTRAINT     �   ALTER TABLE ONLY public.movimiento
    ADD CONSTRAINT fkd8vdh1gws7jn8sjx62m9fdfvk FOREIGN KEY (cuenta_id_cuenta) REFERENCES public.cuenta(id_cuenta);
 P   ALTER TABLE ONLY public.movimiento DROP CONSTRAINT fkd8vdh1gws7jn8sjx62m9fdfvk;
       public          postgres    false    220    3195    222               |   x���K
�0F��U�H���1vV� '�F��&����L�ӡS��y�[�
-3���<���	Zj孱�+��$:�g��N����������Z�����5�����\RM^�<���'�!���0�         >   x�3�,�41�07��4200�t��/*��4���2����q#����,��b���� e�@           x�}���0�q4�h?η*�.��}Q�A 2y��H3��ٵ&�x��J�͠}%�j"R�����p;*ӧ�B��e���
6���Fo��|��h*�@��B��A��CA�ʍ<�7�౽����������8	�ܩ�3��	�L�tR�7�L�����Q�9	�pxq^�-�yY���m��ˇtz3u!����y[�����mw^/������g����e�=<�Y�a�B/�kj�     