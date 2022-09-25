import React, {useState} from 'react';
import Navigation from './shared/navigation';
import Link from 'next/link';
import GUButton from '@components/control/gu-button';
import classNames from 'classnames';
import {renderThemeClass} from '@common/functions';
import HeaderSearch from './shared/search';
import SlideEffect from '@components/animation/slide-effect';
import styled from 'styled-components';
import LoginModal from "@components/modal/login";
import RegisterModal from "@components/modal/register";

const StyledButton = styled(GUButton)`
  font-size: 14px;
  padding: revert-layer;
`;

const Header = ({theme}: { theme?: 'primary' | 'secondary' | 'third' | 'fourth' }) => {
  const [isOpenNavMobile, setIsOpenNavMobile] = useState<boolean>(false);

  const [shouldShowSearch, setShouldShowSearch] = useState(false);

  const [isOpenLogin, openModal] = useState(false);

  const [isOpenRegister, openRegisterModal] = useState(false);


  console.log(isOpenLogin)
  return (
    <>
      <div className="header-spacing"/>
      <header className={classNames(renderThemeClass(theme))}>
        <div className="container">
          <SlideEffect in={shouldShowSearch}>
            <HeaderSearch/>
          </SlideEffect>
          <div className="header-wrapper">
            <div className="float-left d-flex d-lg-flex">
              <div className="d-block">
                <Link href="/">
                  <a className="header-logo" href="/">
                    <img src="/assets/images/logo.png" alt="Logo"/>
                  </a>
                </Link>
              </div>
              <div className="d-block ml-3">
              </div>
              <Navigation isOpenNavMobile={isOpenNavMobile} setIsOpenNavMobile={setIsOpenNavMobile}/>
            </div>
            <div className="header-icons float-right">
              <GUButton
                onClick={() => setShouldShowSearch(!shouldShowSearch)}
                color={theme}
                className="header-icons__search header-icons__item"
                variant="link">
                <i className="fas fa-search"/>
              </GUButton>

              <div className="float-right ml-1 flex-lg-row">

                <StyledButton className="btn p-3"
                              color={theme}
                              buttonType={'button'}
                              onClick={() => openModal(!isOpenLogin)}
                              variant="link"
                >
                    <i className="fas fa-user"/>&nbsp;&nbsp;Iniciar Sesion
                </StyledButton>
                <StyledButton className="btn p-3"
                              color={theme}
                              buttonType={'button'}
                              onClick={() => openRegisterModal(!isOpenRegister)}
                              variant="link"
                >
                  Registrarse
                </StyledButton>

                <GUButton shape="round" size="small" variant="contained" color="primary" buttonType="button">
                  Publicar un proyecto
                </GUButton>

              </div>
            </div>
          </div>
        </div>
      </header>

      <LoginModal isOpen={isOpenLogin} onCancelClick={() => openModal(false)}/>
      <RegisterModal isOpen={isOpenRegister} onCancelClick={() => openRegisterModal(false)}/>
    </>
  );
};

export default Header;
