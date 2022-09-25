export const renderThemeClass = (theme?: 'primary' | 'secondary' | 'third' | 'fourth') => {
  return (theme && theme === 'secondary') || theme === 'third' || theme === 'fourth' ? `-theme--${theme}` : '';
};

