import React from 'react';
import classNames from 'classnames';
import Link from 'next/link';
import moment from 'moment';
import {ArchiveProps} from './shared';
import {renderThemeClass} from '@common/functions';
import PostCoverDoc from "@components/post/shared/post-cover-doc";
import {ArchiveCoverType} from "@store/slices/archive";


const PostStandardArchive = ({ data, className, theme, hideCover, hideContent, hideInfos }: ArchiveProps) => {
  const renderCover = () => {

    switch (data.type) {
      case ArchiveCoverType.AUDIO:
        // return <PostCoverAudio data={data} />;
      case ArchiveCoverType.VIDEO:
        // return <PostCoverVideo data={data} />;
      case ArchiveCoverType.SLIDE:
        // return <PostCoverSlider data={data} />;
      case ArchiveCoverType.SPLIT:
        // return <PostCoverSplit data={data} slidesToShow={2} />;
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

  return (
    <div className={classNames('post-card', renderType(), renderThemeClass(theme), className)}>
      {!hideCover && renderCover()}
      {!hideContent && (
        <div className="card-content">
          <h5 className="card-content__category">{data.category.name}</h5>
          <Link href="/p/archivo/[id]" as={'/p/archivo/' + data.id}>
            <a className="card-content__title" href={'/p/archivo/' + data.id}>
              {data.title}
            </a>
          </Link>
          {!hideInfos && (
            <div className="card-content__info">
              <div className="card-content__info-item card-content__info-item__author">
                <i className="far fa-user" />
                {/*<Link href="/author/[id]" as={'/author/' + data.user?.id}>*/}
                  <p>{data.user?.fullName}</p>
                {/*</Link>*/}
              </div>
              <div className="card-content__info-item">
                <i className="far fa-clock" />
                <p>{moment(data.publicDate).format('DD/MM/YYYY')}</p>
              </div>
            </div>
          )}
        </div>
      )}
    </div>
  );
};

export default PostStandardArchive;
