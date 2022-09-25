import {renderThemeClass} from '@common/functions';
import classNames from 'classnames';
import React from 'react';
import {ArchiveProps, PostInfo} from './shared';
import moment from 'moment';
import Link from 'next/link';
import styled from 'styled-components';
import GUButton from '@components/control/gu-button';
import {ArchiveCoverType} from "@store/slices/archive";
import PostCoverDoc from "@components/post/shared/post-cover-doc";

const StyledButton = styled(GUButton)`
  text-transform: uppercase;
`;

const PostStardardFullArchive = ({
  data,
  className,
  theme,
  hideButton,
  hideDescription,
  infos = [PostInfo.User, PostInfo.Date, PostInfo.Comment],
}: ArchiveProps) => {
  const renderCover = () => {
    switch (data.type) {
      case ArchiveCoverType.AUDIO:
        // return <PostCoverAudio data={data} />;
      case ArchiveCoverType.VIDEO:
        // return <PostCoverVideo data={data} />;
      case ArchiveCoverType.SLIDE:
        // return <PostCoverSlider data={data} />;
      case ArchiveCoverType.SPLIT:
        // return <PostCoverSplit data={data} />;
      default:
        return <PostCoverDoc data={data} />;
    }
  };

  const renderType = () => {
    switch (data.type) {
      case ArchiveCoverType.AUDIO:
        return '-audio';
      case ArchiveCoverType.VIDEO:
        return '-video';
      default:
        return '';
    }
  };

  const renderInfos = () => {
    return infos.map((item) => {
      switch (item) {
        case PostInfo.User:
          return (
            <div className="card-content__info-item card-content__info-item__author">
              <i className="far fa-user"></i>
              <Link href="/author/[id]" as={'/author/' + data.user.id}>
                <a href={'/author/' + data.user.id}>{data.user.fullName}</a>
              </Link>
            </div>
          );
        case PostInfo.Date:
          return (
            <div className="card-content__info-item card-content__info-item__time">
              <i className="far fa-clock"></i>
              <p>{moment(data.publicDate).format('DD/MM/YYYY')}</p>
            </div>
          );
        case PostInfo.Comment:
          return (
            <div className="card-content__info-item card-content__info-item__comment">
              <i className="far fa-comment"></i>
              <p>{data.comments?.length || 0}</p>
            </div>
          );
        default:
          return <></>;
      }
    });
  };

  return (
    <div className={classNames('post-card', '-full', renderType(), renderThemeClass(theme), className)}>
      {renderCover()}
      <div className="card-content">
        <h5 className="card-content__category">{data.category.name}</h5>
        <Link href="/p/archivo/[id]" as={'/p/archivo/' + data.id}>
          <a className="card-content__title" href={'/p/archivo/' + data.id}>
            {data.title}
          </a>
        </Link>
        <div className="card-content__info">{renderInfos()}</div>
        {!hideDescription && <p className="card-content__description">{data.description}</p>}
        {!hideButton && (
          <StyledButton color={theme} weight="bold" variant="underline">
            Leer mas
          </StyledButton>
        )}
      </div>
    </div>
  );
};

export default PostStardardFullArchive;
