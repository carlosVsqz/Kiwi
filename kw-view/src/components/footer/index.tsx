import {ThemeVariation} from '@common/enum';
import {renderThemeClass} from '@common/functions';
import GUButton from '@components/control/gu-button';
import HeaderTitleLine from '@components/other/header-title-line';
import Socials from '@components/other/socials';
import PostTiny from '@components/post/post-tiny';
import {AppState} from '@store';
import {handleFooterPosts} from '@store/thunk/post';
import classNames from 'classnames';
import React, {ReactNode, useEffect} from 'react';
import {useDispatch, useSelector} from 'react-redux';
import styled from 'styled-components';
import jsx from "@i18n/properties";

interface FooterColProps {
  title: string;
  children: ReactNode;
  colClassName?: string;
  className?: string;
}

const StyledButton = styled(GUButton)`
  margin-bottom: ${15 / 16}em;
  margin-right: ${15 / 16}em;
`;

const FooterCol = ({ title, children, className, colClassName }: FooterColProps) => (
  <div className={colClassName || 'col-12 col-md-6 col-lg-4'}>
    <div className={classNames('footer-col', className)}>
      <HeaderTitleLine title={title} />
      {children}
    </div>
  </div>
);

interface FooterProps {
  theme?: ThemeVariation;
}

const Footer = ({ theme }: FooterProps) => {
  const dispatch = useDispatch();

  const { data } = useSelector((state: AppState) => state.posts.footerList);

  useEffect(() => {
    dispatch(handleFooterPosts({ _limit: 3, type_like: 'image' }));
  }, []);

  return (
    <footer className={classNames(renderThemeClass(theme))}>
      <div className="container">
        <div className="footer-content">
          <div className="row">
            <FooterCol title={jsx.footer.aboutUsTitle} className="-about">
              <p>
                {jsx.footer.aboutUs}
              </p>
              <p>
                {jsx.footer.officeHours}
              </p>
              <div className="contact-method">
                <p>
                  <i className="fas fa-map-marker-alt"></i>
                  {jsx.footer.location}
                </p>
                <p>
                  <i className="far fa-mobile-android"></i>
                  {jsx.footer.phone} | {jsx.footer.cellPhone}
                </p>
                <p>
                  <i className="fas fa-headphones-alt"></i>{jsx.footer.support}
                </p>
              </div>
            </FooterCol>
            <FooterCol title={jsx.footer.featuredPostTitle}>
              {data?.map((item, index) => (
                <PostTiny theme={theme} key={index} data={item} />
              ))}
            </FooterCol>
            <div className="col-12 col-md-12 col-lg-4">
              <div className="row">
                <FooterCol className="-util" colClassName="col-12 col-md-6 col-lg-12" title={jsx.footer.tagsTitle}>
                  <div className="tags-group">

                    {[' Noticias', 'Informativo', 'Obras',].map((item, index) => (
                      <StyledButton href="#" key={index} weight="light" size="small" variant="contained" color="light">
                        {item}
                      </StyledButton>
                    ))}
                  </div>
                </FooterCol>
                <FooterCol colClassName="col-12 col-md-6 col-lg-12" title={jsx.footer.socialTitle}>
                  <Socials
                    spacing={10}
                    height={50}
                    width={50}
                    variant="contained"
                    size="small"
                    shape="circle"
                    color="light"
                  />
                </FooterCol>
              </div>
            </div>
          </div>
        </div>
        <div className="copyright">
          <p>{jsx.footer.copyright}</p>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
