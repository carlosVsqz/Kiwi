export interface NavigationItem {
  title: string;
  link: string;
  active?: string[];
  subMenu?: { title: string; link: string }[];
}

const data: NavigationItem[] = [
  // { title: 'Inicio', },
  {
    title: 'Buscar trabajos',
    link: '/transparencia/general',
    active: ['/transparencia/', '/p/categoria/', '/transparencia/proyectos' ],
    subMenu: [
      { title: 'Por Categoria', link: '/post/category' },
      { title: 'Por Proyecto', link: '/transparencia/archivo' },
    ],
  },
  // {
  //   title: 'ciudad',
  //   link: '/ciudad/historia',
  //   active: ['/ciudad/historia', '/ciudad/cultura', '/ciudad/mapa', ],
  //   subMenu: [
  //     { title: 'Historia', link: '/ciudad/historia' },
  //     { title: 'Cultura y turismo', link: '/ciudad/cultura' },
  //     { title: 'Mapa', link: '/ciudad/mapa' },
  //   ],
  // },
  // { title: 'concejo municipal', link: '/municipalidad/consejo', active: [] },
  // { title: 'Contacto', link: '/municipalidad/contacto', active: [] },
];

export default data;
