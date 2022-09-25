import React from 'react';
import {PostInfo, PostProps} from './shared';
import {renderThemeClass} from '@common/functions';
import classNames from 'classnames';
import Link from 'next/link';
import styled from 'styled-components';
import GUButton from '@components/control/gu-button';

const ButtonContaier = styled.div`
  text-align: left;
  margin: 50px 80px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
`;

const StyledButton = styled(GUButton)`
  text-transform: uppercase;
`;

const MainPostInline = ({
                          data,
                          theme,
                          className,
                          hide = [],
                          infos = [PostInfo.User, PostInfo.Date, PostInfo.Comment],
                        }: PostProps & { hide?: string[] }) => {

  const categories = [];

  data.category.forEach((data) => {
    categories.push(<h5 className="card-content__category">{data.name}</h5>)
  });

  return (
    <div className={classNames('post-card', '-inner-text', className, renderThemeClass(theme))}>
      <div className="card-cover">
        <img src={data.image as string} alt={data.title}/>
      </div>
      <div className="card-content">

        <h1 className="card-content__title" >
          {data.title}
        </h1>
        <h4 className="card-content__description card-content__title">
          {data.description}
        </h4>

        <div>
          {/*<ButtonContaier>*/}
          <div className={"d-flex flex-lg-row flex-sm-column row justify-content-lg-between my-5"}>
            <Link href="/post/create">
              <StyledButton
                className={"col-lg-5 col-md-4 col-sm-12"}
                variant="contained"
                color={theme}
                shape="round"
                weight="bold">
                Contratar a un dependiente
              </StyledButton>
            </Link>
            <div className="d-sm-block mt-2 d-lg-none" style={{height: '10px', width:'10px'}}></div>
            <Link href="/posts">
              <StyledButton
                className={"col-lg-4 px-lg-0 col-md-4 col-sm-12"}
                // onClick=
                variant="contained"
                color={"third"}
                shape="round"
                weight="bold">
                Encontrar trabajos
              </StyledButton>
            </Link>
          </div>
        </div>

      </div>
    </div>
  );
};

export default MainPostInline;
